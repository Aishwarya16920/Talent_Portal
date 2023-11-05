package com.zensar.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zensar.tp.entity.UserDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginServiceDelegateImpl implements LoginServiceDelegate{
    
    @Autowired
    RestTemplate restTemplate;
    
    @Override
  @CircuitBreaker(name="jobseeker-service-Token",fallbackMethod="fallbackForGetten")
    public boolean isLoggedInUser(String authToken) {
        HttpHeaders header=new HttpHeaders();
        header.set("Authorization", authToken);
        HttpEntity entity=new HttpEntity(header);
        try {
        	
        
        ResponseEntity<Boolean> result =
                this.restTemplate.exchange("http://API-GATEWAY/talentportal/token/validate",  
                        HttpMethod.GET, entity, Boolean.class);
        }
        catch(Exception e) {
        	return false;
        }
        return true;
                
    }

	@Override
	@CircuitBreaker(name="jobseeker-service-Token",fallbackMethod="fallbackForRole")
	public String role(String authToken) {
		
		        HttpHeaders header=new HttpHeaders();
		        header.set("Authorization", authToken);
		        HttpEntity entity=new HttpEntity(header);
		        ResponseEntity<UserDetails> user = this.restTemplate.exchange("http://API-GATEWAY/talentportal/user", HttpMethod.GET, entity, UserDetails.class);
		        UserDetails role=user.getBody();
		        
		        return role.getRole();
		        
		    }
	@Override
	public String username(String authToken) {
	        
	        
	        
	        HttpHeaders header=new HttpHeaders();
	        header.set("Authorization", authToken);
	        HttpEntity entity=new HttpEntity(header);
	        ResponseEntity<UserDetails> user = this.restTemplate.exchange("http://API-GATEWAY/talentportal/user", HttpMethod.GET, entity, UserDetails.class);
	           UserDetails username=user.getBody();
	           
	            return username.getUsername();
	            
	        }
	
	public boolean fallbackForGetten(String authToken,Exception e) {
		System.out.println("Token Not Working");
		return false;
	}
	public String fallbackForRole(String authToken,Exception e) {
		System.out.println("Role Not Working");
		return null;
	}
	
	
	    
	}


    