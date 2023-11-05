package com.zensar.tp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.tp.dto.Employer;
import com.zensar.tp.dto.Job;
import com.zensar.tp.dto.UpdatingEmployerdto;
import com.zensar.tp.exceptions.InvalidException;
import com.zensar.tp.services.EmployerService;
import com.zensar.tp.services.LoginServiceDelegate;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private LoginServiceDelegate loginServiceDelegate;
	
	//Post a new Job
	@Operation(summary="post job application",description="This service adds a admin portal")
	@PostMapping(value = "/job", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employer> postNewJob(@RequestBody Employer employer, @RequestHeader("Authorization") String authToken) {
		String token=authToken;
        authToken = authToken.substring(7, authToken.length());
		if(!loginServiceDelegate.isLoggedInUser(authToken)) {
			String username =loginServiceDelegate.username(token);
			String role="ROLE_ADMIN";
			if(loginServiceDelegate.role(token).equals(role)) {
				employer=employerService.postNewJob(employer, username);
				return  new ResponseEntity<Employer>(employer,HttpStatus.CREATED);
		    }
		}
		return  new ResponseEntity<Employer>(HttpStatus.BAD_REQUEST);
	} 
	
	//List of all jobs in portal
    @Operation(summary="job search",description="This service gets all jobs posted by employer")
    @GetMapping(value = "job/search", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Job> getAllJobs(){
        List<Job> list =employerService.getAllJobs();
        return list;
    }
    
    @Operation(summary="job search",description="This service gets all jobs posted by employer along with application status")
    @GetMapping(value = "job/search/status", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Job> getAllJobsWithApplicationStatus(@RequestHeader("Authorization") String authToken){
        String username= loginServiceDelegate.username(authToken);
        List<Job> list =employerService.getAllJobsWithApplicationStatus(username);
        return list;
    }
	
	//Read all jobs posted by employer
	@Operation(summary="get job",description="This service adds a admin portal")
	@GetMapping(value = "/job", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Employer> readAllJobs(@RequestHeader("Authorization") String authToken){
		String token=authToken;
        authToken = authToken.substring(7, authToken.length());
		if(!loginServiceDelegate.isLoggedInUser(authToken)) {
			String username =loginServiceDelegate.username(token);
			String role="ROLE_ADMIN";
			if(loginServiceDelegate.role(token).equals(role)) {
				List<Employer> list =employerService.readAllJobs(username);
				return list;
		    }
		}
		throw new InvalidException("Invalid User");
	}
	
	//Updates an existing job
	@Operation(summary="update employer job",description="This service adds a admin portal")
	@PutMapping(value = "/updatejob/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UpdatingEmployerdto> updateExistingJob(@PathVariable("id") int id,@RequestBody UpdatingEmployerdto employer, @RequestHeader("Authorization") String authToken) {
		String token=authToken;
        authToken = authToken.substring(7, authToken.length());
		if(!loginServiceDelegate.isLoggedInUser(authToken)) {
			String username =loginServiceDelegate.username(token);
			String role="ROLE_ADMIN";
		       if(loginServiceDelegate.role(token).equals(role)) {
			employer=employerService.updateExistingJob(employer,id,username);
			return  new ResponseEntity<UpdatingEmployerdto>(employer,HttpStatus.CREATED);
		       }
		}
		return  new ResponseEntity<UpdatingEmployerdto>(HttpStatus.BAD_REQUEST);
	} 
	
	//Deletes specific job posted by logged in user
		@DeleteMapping(value="/deletejob/{id}")
	    @Operation(summary="Deletes category by ID", description= "This request deletes specifies category with mentioned Id BY THE USER that is present in the database")
	    public ResponseEntity<Employer> deleteJobById(@PathVariable("id") int id, @RequestHeader("Authorization") String authToken) {
			String token=authToken;
	        authToken = authToken.substring(7, authToken.length());
			if(!loginServiceDelegate.isLoggedInUser(authToken)) {
	        	if(loginServiceDelegate.role(token).equals("ROLE_ADMIN")) {
	        		Employer emp = employerService.deleteJobById(id);
	        		if(emp!= null) {
	        			return new ResponseEntity<Employer>(emp,HttpStatus.OK);
	        		}
	        	}
	        }
	        
	        return new ResponseEntity<Employer>(HttpStatus.BAD_REQUEST);
	            
	    }    
		
	

}
