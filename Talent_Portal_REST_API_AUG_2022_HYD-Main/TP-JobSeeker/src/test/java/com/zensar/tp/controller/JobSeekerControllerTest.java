package com.zensar.tp.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.ApplicantsDto;
import com.zensar.tp.dto.Applicationstatus;
import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.dto.JobStatus;
import com.zensar.tp.dto.JobsApplied;
import com.zensar.tp.entity.JobApplication;
import com.zensar.tp.entity.JobApplicationEntity;
import com.zensar.tp.entity.JobEntity;
import com.zensar.tp.service.JobApplicationService;
import com.zensar.tp.service.LoginServiceDelegate;

@WebMvcTest(PostJobController.class)
public class JobSeekerControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	JobApplicationService jobService;
	@MockBean
	LoginServiceDelegate loginServiceDelegate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testJobApplication() throws Exception{
		JobApplicationDto user = new JobApplicationDto();
		user.setJobId(1);
		user.setUserName("");
		user.setId(1);
		user.setJobId(2);
		user.setStatusId(1);
		
		when(this.jobService.postJob(user)).thenReturn(user);
		
		 MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8070/jobseeker/jobid")
		    		.contentType("application/json")
		    		.content(objectMapper.writeValueAsString(user)))
		    		.andExpect(status().isCreated())
		    		.andReturn();
		    		String response = mvcResult.getResponse().getContentAsString();
					assertEquals(response.contains(""), true);
		}
	
	
	 @Test
	 public void testJobApplications() throws Exception{
		 			JobApplicationDto user = new JobApplicationDto();
		            user.setJobId(1);
		            user.setJobId(1);
		    		user.setUserName("anand");
		    		user.setId(1);
		    		user.setJobId(2);
		    		user.setStatusId(1);
					
				    when(this.jobService.postJob(user)).thenReturn(user);
				    
				    MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8070/jobseeker/jobid")
				    		.contentType("application/json")
				    		.content(objectMapper.writeValueAsString(user)))
				    		.andExpect(status().isCreated())
				    		.andReturn();
				    		String response = mvcResult.getResponse().getContentAsString();
							assertEquals(response.contains("Saketh"), false);
	 }
	 
	 
	 
	 
	 
	 @Test
	 public void testsearchitem() throws Exception{
		 List<JobEntity> list=new ArrayList<>();
		 list.add(new JobEntity("dotnet","abc",1,3,"Java","cpp", "Pune", "Applied"));
		 list.add(new JobEntity("Dotnet","abc",2,6,"python","php", "Chennai", "Applied"));
		 when(jobService.findBySkill("Java")).thenReturn(list);
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/search/Java")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 ).andExpect(status().isOk()).andReturn();
		 String str = mvc.getResponse().getContentAsString();
		 assertEquals(str.contains("Java"),true);
		 }
	 
	 @Test
	 public void testsearchiteminvalid() throws Exception{
		 List<JobEntity> list=new ArrayList<>();
		 list.add(new JobEntity("dotnet","abc",1,3,"php","cpp", "Pune", "Applied"));
		 list.add(new JobEntity("Dotnet","abc",2,6,"python","php", "Chennai", "Applied"));
		 when(jobService.findBySkill("Java")).thenReturn(list);
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/search/Java")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 ).andExpect(status().isOk()).andReturn();
		 String str = mvc.getResponse().getContentAsString();
		 assertEquals(str.contains("Java"),false);
		 }
	 
	 @Test
	 public void testgetjobswithstatusinvalid() throws Exception{
			 List<JobStatus> list=new ArrayList<>();
			// list.add(new JobStatus(1,"saketh","Rejected","dotnet","Pune"));
			 list.add(new JobStatus(2,"surya","Applied","Dotnet","Chennai"));
			 HttpHeaders httpHeaders = new HttpHeaders();
			 httpHeaders.set("Authorization", "AS16234567890");
			 when(jobService.getbyjobStatus(null)).thenReturn(list);
			 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_USER");
			 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/userjobStatus")
					 .contentType(MediaType.APPLICATION_JSON_VALUE)
					 .headers(httpHeaders)
					 ).andExpect(status().isOk()).andReturn();
			 String str = mvc.getResponse().getContentAsString();
			 assertEquals(str.contains("Applied"),true);
			 }
	 
	 @Test
	 public void testgetjobswithstatus() throws Exception{
			 List<JobStatus> list=new ArrayList<>();
			// list.add(new JobStatus(1,"saketh","Rejected","dotnet","Pune"));
			 list.add(new JobStatus(2,"surya","Applied","Dotnet","Chennai"));
			 HttpHeaders httpHeaders = new HttpHeaders();
			 httpHeaders.set("Authorization", "AS16234567890");
			 when(jobService.getbyjobStatus(null)).thenReturn(list);
			 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_USER");
			 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/userjobStatus")
					 .contentType(MediaType.APPLICATION_JSON_VALUE)
					 .headers(httpHeaders)
					 ).andExpect(status().isOk()).andReturn();
			 String str = mvc.getResponse().getContentAsString();
			 assertEquals(str.contains("Rejected"),false);
			 }
	 
	 @Test
	 public void testgetjobsbyuserstatusinvalid() throws Exception{
			 List<ApplicantsDto> list=new ArrayList<>();
			 list.add(new ApplicantsDto(1,"java","Applied","saketh"));
			 //list.add(new ApplicantsDto(2,"cpp","Rejected","surya"));
			 HttpHeaders httpHeaders = new HttpHeaders();
			 httpHeaders.set("Authorization", "AS16234567890");
			 when(jobService.getbyuserStatus(null)).thenReturn(list);
			 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
			 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/userStatus")
					 .contentType(MediaType.APPLICATION_JSON_VALUE)
					 .headers(httpHeaders)
					 ).andExpect(status().isOk()).andReturn();
			 String str = mvc.getResponse().getContentAsString();
			 assertEquals(str.contains("Rejected"),false);
			 }
	 
	 
	 
	 @Test
	 public void testgetjobsbyuserstatus() throws Exception{
			 List<ApplicantsDto> list=new ArrayList<>();
			 list.add(new ApplicantsDto(1,"java","Applied","saketh"));
			 //list.add(new ApplicantsDto(2,"cpp","Rejected","surya"));
			 HttpHeaders httpHeaders = new HttpHeaders();
			 httpHeaders.set("Authorization", "AS16234567890");
			 when(jobService.getbyuserStatus(null)).thenReturn(list);
			 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
			 MvcResult mvc = mockMvc.perform(get("http://localhost:8070/jobseeker/userStatus")
					 .contentType(MediaType.APPLICATION_JSON_VALUE)
					 .headers(httpHeaders)
					 ).andExpect(status().isOk()).andReturn();
			 String str = mvc.getResponse().getContentAsString();
			 assertEquals(str.contains("Applied"),true);
			 }
	 
	 
	 @Test
	 public void testgetupdateuserstatus() throws Exception{
		     List<JobApplication> list=new ArrayList<>();
		     list.add(new JobApplication(1,"saketh",11,2));
			JobApplication list1=new JobApplication(1,"saketh",11,2);
			// JobApplication dto= new JobApplication(1,"saketh",11,2);
			
			 //list.add(new ApplicantsDto(2,"cpp","Rejected","surya"));
			 HttpHeaders httpHeaders = new HttpHeaders();
			 httpHeaders.set("Authorization", "AS16234567890");
			 when(jobService.updateuserStatus(list1,"saketh")).thenReturn(list1);
			 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
			 MvcResult mvc = mockMvc.perform(put("http://localhost:8070/jobseeker/updateuserStatus")
					 .contentType("application/json")
			    		.content(objectMapper.writeValueAsString(list)))
			    		.andExpect(status().isBadRequest())
			    		.andReturn();
			 String str = mvc.getResponse().getContentAsString();
			 assertEquals(str.contains("saketh"),false);
			 }
	 
	}


	
