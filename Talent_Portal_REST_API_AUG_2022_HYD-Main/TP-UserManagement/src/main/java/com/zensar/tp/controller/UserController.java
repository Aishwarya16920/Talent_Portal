package com.zensar.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.tp.dto.AuthenticationRequest;
import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.dto.Userdto;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.service.LogutUserService;
import com.zensar.tp.service.RegisterUserService;
import com.zensar.tp.service.UserService;
import com.zensar.tp.utils.JwtUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/talentportal")
public class UserController { 
	@Autowired
    RegisterUserService registerService;
	@Autowired
	LogutUserService logoutUserService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired 
	UserService userService;

	@ApiOperation(value="Admin or User Authentication",notes="This API endpoint is used for Authentication")
	@PostMapping(value="/authenticate",consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Userdto> authenticate(@RequestBody AuthenticationRequest authRequest){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
					);
		}
		catch(BadCredentialsException e) {
			throw new InvalidUserDataException(e.getMessage());
		}
		
	String jwtToken=jwtUtils.generateToken(authRequest.getUsername());
	UserDetails user=userDetailsService.loadUserByUsername(authRequest.getUsername());
    String roleuser=user.getAuthorities().toString();
    Userdto userdto=new Userdto(jwtToken,authRequest.getUsername(),roleuser);
	
		return new ResponseEntity<>(userdto,HttpStatus.OK);
		
	}
	@PostMapping(value="/users",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="create new user",notes="This service adds a new user")
	public ResponseEntity<RegisterUser> createNewUser(@RequestBody RegisterUser user) {
		
			
		user=registerService.createNewUser(user);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	
	
	}
	@GetMapping(value="/token/validate")
    @ApiOperation(value="Validation of token", notes="This request validates the token with jwtToken")
    public ResponseEntity<Boolean> isTokenValid(@RequestHeader("Authorization") String jwtToken) {
        jwtToken = jwtToken.substring(7, jwtToken.length());
        boolean isTokenValid = false;
        try {
        String username = jwtUtils.extractUsername(jwtToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        isTokenValid = jwtUtils.validateToken(jwtToken, userDetails);
        }
        catch(Exception e){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        if(isTokenValid) {
            return new ResponseEntity<>(true, HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
	 @DeleteMapping(value="/user/logout")
	    @ApiOperation(value="Logout of a user", notes="This request moves the jwt token into blacklist and logs out the user")
	    public ResponseEntity<Boolean> logoutUser(@RequestHeader("Authorization") String jwtToken) {
	        boolean isTokenValid = this.isTokenValid(jwtToken).getBody();
	      
	        if(isTokenValid) {
	            logoutUserService.logoutUser(jwtToken);
	            return new ResponseEntity<>(true, HttpStatus.OK);
	        }
	        
	       
	        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);



	     
	        }
	 @ApiOperation(value="Return Valid User Info",notes="This API endpoint is used for returning valid User Info")
	    @GetMapping(value="/user", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	    public ResponseEntity<RegisterUser> returnUsersInfo (@RequestHeader("Authorization")String jwtToken){
		 String token=jwtToken;
		 jwtToken = jwtToken.substring(7, jwtToken.length());   
		 String username = jwtUtils.extractUsername(jwtToken);
	        
	        if(!logoutUserService.check(token))
	        {
	        RegisterUser user;
	        user = userService.findUserByUsername(username).get(0);
	        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	        }
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 }

	 
}
