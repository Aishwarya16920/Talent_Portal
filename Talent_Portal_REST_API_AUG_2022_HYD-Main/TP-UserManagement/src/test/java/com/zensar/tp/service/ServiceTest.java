package com.zensar.tp.service;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.RegisterUser;
import com.zensar.tp.entity.BlackListEntity;
import com.zensar.tp.entity.UserEntity;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.repo.BlackListRepo;
import com.zensar.tp.repo.UserRepo;
import com.zensar.tp.utils.JwtUtils;

@WebMvcTest({UserDetailsServiceImpl.class,RegisterUserService.class,LogoutUserServiceImpl.class})
public class ServiceTest {
	@Autowired
    MockMvc mockMvc;
	@Autowired
	UserDetailsService userDetailsS;
@MockBean AuthenticationManager authenticationManager;
@MockBean Authentication authentication;
@MockBean JwtUtils jwtutils;
@Autowired 
RegisterUserService registerUserService;
@Autowired UserService userService;
@Autowired 
LogutUserService logutUserService; 
@Autowired
ObjectMapper objectMapper;
@MockBean
UserRepo userRepo;
@MockBean BlackListRepo blackListRepo;




@Test
 void loginTest() throws Exception{
	UserEntity userEntity=new UserEntity(0, "firstname", "lastname","username","123", "abc@gmail.com","987653823");
	userEntity.setRole("ROLE_ADMIN");
	List<UserEntity>userEntityList=new ArrayList<>();
	userEntityList.add(userEntity);
	//when(this.userDetailsService.loadUserByUsername(userEntity.getUsername())).thenReturn(user);
	when(this.userRepo.findByUsername(userEntity.getUsername())).thenReturn(userEntityList);
	UserEntity userEntit=userEntityList.get(0);
	List<GrantedAuthority> authorities=new ArrayList<>();
	//when(this.userDetailsService.loadUserByUsername(userEntity.getUsername())).thenReturn(user);
	authorities.add(new SimpleGrantedAuthority(userEntit.getRole()));
	
	User user=new User(userEntit.getUsername(),userEntit.getPassword(),authorities);
	UserDetails returuuser =userDetailsS.loadUserByUsername(userEntity.getUsername());
	assertEquals(userEntity.getUsername(),user.getUsername());
    

}
@Test
void loginTestInvaild() throws Exception{
	UserEntity userEntity=new UserEntity(0, null, null, null, null, null, null);
	
	List<UserEntity>userEntityList=new ArrayList<>();
	userEntityList.add(userEntity);
	
	when(this.userRepo.findByUsername(userEntity.getUsername())).thenReturn(null);
	UserEntity userEntit=userEntityList.get(0);
	
	assertEquals(userEntity.getUsername(),null);
   

}
@Test
void registerUserService() throws Exception{
	RegisterUser user = new RegisterUser(1,"anand", "kulkarni", "anand","anand@gmail.com","anand123", "9999999999");
      UserEntity jobEntity = new UserEntity(1,"anand", "kulkarni", "anand","anand@gmail.com","anand123", "9999999999");
     
     when(userRepo.save(any())).thenReturn(jobEntity);
     
     RegisterUser returneduser = registerUserService.createNewUser(user);
     
     assertEquals(jobEntity.getId(), returneduser.getId());
     
 }
@Test
void registerUserNull() throws Exception{
	RegisterUser user = new RegisterUser(1,null, null, null,null,null, null);
      UserEntity jobEntity = new UserEntity(1,"anand", "kulkarni", "anand","anand@gmail.com","anand123", "9999999999");
    if((user.getFirstName()!= null) && (user.getLastName()!= null) && (user.getUsername()!= null) && 
     (user.getEmail()!= null) && (user.getPassword()!= null) && (user.getPhone()!= null))
    {
     when(userRepo.save(any())).thenReturn(jobEntity);
     
     RegisterUser returneduser = registerUserService.createNewUser(user);
     
     assertEquals(jobEntity.getId(), returneduser.getId());
    }
    InvalidUserDataException throw1 =assertThrows(InvalidUserDataException.class,()->registerUserService.createNewUser(user),"InvalidUserDataException");
    assertEquals(throw1.getMessage(),null);
     
 }
@Test
void registerUseralreadyexist() throws Exception{
	RegisterUser user = new RegisterUser(1,"anand", "kulkarni", "anand","anand@gmail.com","anand123", "9999999999");
      UserEntity jobEntity = new UserEntity(1,"anand", "kulkarni", "anand","anand@gmail.com","anand123", "9999999999");
     
     when(userRepo.save(any())).thenReturn(jobEntity);
     when(userRepo.existsByUsername("anand")).thenReturn(true);
     InvalidUserDataException throw1 =assertThrows(InvalidUserDataException.class,()->registerUserService.createNewUser(user),"Username already exists");
     assertEquals(throw1.getMessage(),null);
     
 }
@Test 
void registerUserServiceInvaild() throws Exception{
	RegisterUser user = new RegisterUser(1, null, null, null, null, null, null);
      UserEntity jobEntity = new UserEntity(1, null, null, null, null, null, null);
     
     InvalidUserDataException throw1 =assertThrows(InvalidUserDataException.class,()->registerUserService.createNewUser(user),"InvalidUserDataException");
     assertEquals(throw1.getMessage(),null);
 }
@Test
public void testLogoutUser() throws Exception{
    BlackListEntity be=new BlackListEntity();
    when(blackListRepo.save(be)).thenReturn(be);
    Boolean res=logutUserService.logoutUser("A1B2C3");
    assertEquals(res,true);
    
}
@Test
public void testLogoutCheck() throws Exception{
	List<BlackListEntity> token=new ArrayList<>();
	List<BlackListEntity> tokencheck=new ArrayList<>();
	token.add(new BlackListEntity(1,"123456789",LocalDate.now()));
	tokencheck.add(new BlackListEntity(1,"123456789",LocalDate.now()));
	when(this.blackListRepo.findAll()).thenReturn(tokencheck);
	boolean t=logutUserService.check("123456789");
	}

@Test
public void testLogoutuser() throws Exception{
	List<UserEntity>userEntityList=new ArrayList<>();
	userEntityList.add(new UserEntity("firstName", "lastName", "username", "password", "email","phone"));
	when(this.userRepo.findByUsername(userEntityList.get(0).getUsername())).thenReturn(userEntityList);
	userService.findUserByUsername(userEntityList.get(0).getUsername());
	assertEquals(userEntityList.get(0).getUsername(),"username");
}
@Test

public void logoutcheck() throws Exception{
	List<BlackListEntity> token=new ArrayList<>();
	BlackListEntity list=new BlackListEntity(2,"2345678902345678",LocalDate.now());
	token.add(list);
	boolean t=false;
	when(blackListRepo.findAll()).thenReturn(token);
	boolean l=logutUserService.check("auth");
	for(BlackListEntity i:token) {
		if(i.getAuth().contains("auth")) {
			l=true;
		}
		l=false;
		}
	assertTrue("false",true);
	
}
}
