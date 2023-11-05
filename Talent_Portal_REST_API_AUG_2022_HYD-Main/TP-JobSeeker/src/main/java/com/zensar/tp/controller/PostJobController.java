package com.zensar.tp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.tp.dto.ApplicantsDto;
import com.zensar.tp.dto.Applicationstatus;
import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.dto.JobStatus;
import com.zensar.tp.dto.JobsApplied;
import com.zensar.tp.entity.JobApplication;
import com.zensar.tp.entity.JobApplicationEntity;
import com.zensar.tp.entity.JobEntity;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.service.JobApplicationService;
import com.zensar.tp.service.LoginServiceDelegate;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/jobseeker")
public class PostJobController { 
	@Autowired
    JobApplicationService jobApplicationService;
	@Autowired
	LoginServiceDelegate loginServiceDelegate;
	
	
	
	@Operation(summary="Search the job protal using skill as the key",description="This API endpoint is used for Searching")
    @GetMapping(value="/search/{search}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    
    public ResponseEntity <List<JobEntity>> findByskill(@PathVariable("search")String search) {
        
            
        List<JobEntity> searchItem=jobApplicationService.findBySkill(search);
        return ResponseEntity.ok(searchItem);   
	}
		
	
	@Operation(summary="To Apply job",description="This API endpoint is used for applying a job")
		@PostMapping (value = "/jobid",consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<JobApplicationDto> postJob(@RequestBody JobApplicationDto jobApplication) {
				
			jobApplication=jobApplicationService.postJob(jobApplication);
				return new ResponseEntity<JobApplicationDto>(jobApplication,HttpStatus.CREATED);
			}
		
	//for user
	@Operation(summary="To get the jobs of particular  users",description="This API endpoint is used for Getting jobs for particular user")
		@GetMapping(value = "/userjobStatus", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<List<JobStatus>> getjobswithstatus( @RequestHeader("Authorization") String authToken ){
			String token=authToken;
	        authToken = authToken.substring(7, authToken.length());
	       if(!loginServiceDelegate.isLoggedInUser(authToken)) {
	    	   String username=loginServiceDelegate.username(token);
			return new ResponseEntity<>(jobApplicationService.getbyjobStatus(username),HttpStatus.OK);
	}
			throw new InvalidUserDataException("Invalid User");
			
	}
		
		//For admin
	@Operation(summary="Get user with Status",description="This API endpoint is used to get User with Status")
		@GetMapping(value = "/userStatus"	, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<List<ApplicantsDto>> getuserwithstatus( @RequestHeader("Authorization") String authToken ){
			String token=authToken;
	        authToken = authToken.substring(7, authToken.length());
	       if(!loginServiceDelegate.isLoggedInUser(authToken)) {
	    	   String username=loginServiceDelegate.username(token);	
			return new ResponseEntity<>(jobApplicationService.getbyuserStatus(username),HttpStatus.OK);
	}
			throw new InvalidUserDataException("Invalid User");
		}
		
	@Operation(summary="Update User Status ",description="This API endpoint is used to update job status for a user")
		@PutMapping(value = "/updateuserStatus"	,consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<JobApplication> getupdateuserwithstatus( @RequestHeader("Authorization") String authToken,@RequestBody JobApplication applicants){
			String token=authToken;
	        authToken = authToken.substring(7, authToken.length());
	       if(!loginServiceDelegate.isLoggedInUser(authToken)) {
	    	   String username=loginServiceDelegate.username(token);
			return new ResponseEntity<>(jobApplicationService.updateuserStatus(applicants,username),HttpStatus.OK);
	}
			throw new InvalidUserDataException("Invalid User");
		}
		
		

}
