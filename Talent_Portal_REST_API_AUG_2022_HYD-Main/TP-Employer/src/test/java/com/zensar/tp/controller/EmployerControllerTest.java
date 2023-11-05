package com.zensar.tp.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.zensar.tp.dto.Employer;
import com.zensar.tp.dto.Job;
import com.zensar.tp.dto.UpdatingEmployerdto;
import com.zensar.tp.repository.JobRepository;
import com.zensar.tp.services.EmployerService;
import com.zensar.tp.services.LoginServiceDelegate;

@WebMvcTest(EmployerController.class)
public class EmployerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmployerService employerService;
	
	@MockBean
	JobRepository employerRepository;
	
	@MockBean
	LoginServiceDelegate loginServiceDelegate;
	
	@Autowired
	ObjectMapper objectMapper;
	
	//Post a new Job
	@Test
	public void testPostNewJob() throws Exception
	{
		Employer employer = new Employer();
		employer.setId(1);
		employer.setTitle("DotNet Developer");
		employer.setLocation("Pune");
		employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
		employer.setMaxExp(8);
		employer.setMinExp(2);
		employer.setPrimarySkill("C# ADO.NET");
		employer.setSecSkills("Devops, Cloud Basics, React");
		employer.setStatus("Open");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "AS16234567890");
		
		when(employerService.postNewJob(employer, null)).thenReturn(employer);
		when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
		MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8060/employer/job/")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(employer))
		.headers(httpHeaders)
		).andExpect(status().isCreated())
		.andExpect(content().string(containsString("C# ADO.NET")))
		.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("C# ADO.NET"), true);

	}
	
	@Test
	public void testPostNewJobInvalid() throws Exception
	{
		Employer employer = new Employer();
		employer.setId(1);
		employer.setTitle("DotNet Developer");
		employer.setLocation("Pune");
		employer.setDescription("null");
		employer.setMaxExp(8);
		employer.setMinExp(2);
		employer.setPrimarySkill("C# ADO.NET");
		employer.setSecSkills("Devops, Cloud Basics, React");
		employer.setStatus("Open");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "AS16234567890");
		
		when(employerService.postNewJob(employer,null)).thenReturn(employer);
		when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
		MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:8060/employer/job/")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(employer))
		.headers(httpHeaders)
		).andExpect(status().isCreated())
		.andExpect(content().string(containsString("null")))
		.andReturn();
		
		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("null"), true);

	}
	
	//List of all jobs in portal
	 @Test
	    public void testGetAllJob() throws Exception {
		 List<Job> list = new ArrayList<>();
		 list.add(new Job(1, "React", "Cloud", "Pune", "Front End Developer", 2, 4,
					"Front End Developer with 2 years of experience", null));
		 list.add(new Job(2, "Java", "Python", "Chennai", "Java Developer", 3, 5,
					"Java Developer with 3 years of experience", null));
		 list.add(new Job(3, "DotNet", "Java", "Hyderabad", "DotNet Developer", 2, 3,
					"DotNet Developer with 2 years of experience", null));
		 
		 when(employerService.getAllJobs()).thenReturn(list);
		 
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8060/employer/job/search")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		         String str = mvc.getResponse().getContentAsString();
		         
		         assertEquals(str.contains("React"),true);
		          
		 
	    }
	 @Test
	    public void testGetAllJobs() throws Exception {
		 List<Job> list = new ArrayList<>();
		 list.add(new Job(1, "Java", "Python", "Chennai", "Java Developer", 3, 5,
					"Java Developer with 3 years of experience", null));
		 list.add(new Job(2, "React", "Cloud", "Pune", "Front End Developer", 2, 4,
					"Front End Developer with 2 years of experience", null));
		 list.add(new Job(3, "DotNet", "Java", "Hyderabad", "DotNet Developer", 2, 3,
					"DotNet Developer with 2 years of experience", null));
		 
		 when(employerService.getAllJobs()).thenReturn(list);
		 
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8060/employer/job/search")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		         String str = mvc.getResponse().getContentAsString();
		         
		         assertEquals(str.contains("Java"),true);
		          
		 
	    }
	 
	//Read all jobs posted by employer
	 @Test
	    public void testReadAllJob() throws Exception {
		 List<Employer> list = new ArrayList<>();
		 list.add(new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage",2, 5, "C# ADO.NET","Devops, Cloud Basics, React", "Pune", "Open", "admin"));
		 list.add(new Employer(2, "Java Developer", "A java developer minimum 3 years’ experience.",2, 5, "Java","Cloud Basics, React", "Bangalore", "Open", "admin"));
		 list.add(new Employer(3, "Java Developer", "A java developer minimum 6 years’ experience.",2, 5, "Java","React", "Hyderabad", "Open", "admin"));
		 
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.set("Authorization", "AS16234567890");
		 
		 when(employerService.readAllJobs(null)).thenReturn(list);
		 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
		 
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8060/employer/job/")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 .headers(httpHeaders)
				 ).andExpect(status().isOk()).andReturn();
		         String str = mvc.getResponse().getContentAsString();
		         
		         assertEquals(str.contains("Java Developer"),true);
		          
		 
	    }
	 @Test
	    public void testReadAllJobs() throws Exception {
		 List<Employer> list = new ArrayList<>();
		 list.add(new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage",2, 5, "C# ADO.NET","Devops, Cloud Basics, React", "Pune", "Open", "admin"));
		 list.add(new Employer(1, "Java Developer", "A java developer minimum 3 years’ experience.",2, 5, "Java","Cloud Basics, React", "Bangalore", "Open", "admin"));
		 list.add(new Employer(1, "Java Developer", "A java developer minimum 6 years’ experience.",2, 5, "Java","React", "Hyderabad", "Open", "admin"));
		 
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.set("Authorization", "AS16234567890");
		 
		 when(employerService.readAllJobs(null)).thenReturn(list);
		 when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
		 
		 MvcResult mvc = mockMvc.perform(get("http://localhost:8060/employer/job/")
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 .headers(httpHeaders)
				 ).andExpect(status().isOk()).andReturn();
		         String str = mvc.getResponse().getContentAsString();
		         
		         assertEquals(str.contains("DotNet Developer"),true);
		          
		 
	    }
	 
	 //Updates an existing job
	 @Test
		public void testupdatejob() throws Exception
		{
			UpdatingEmployerdto employer = new UpdatingEmployerdto();
			employer.setId(1);
			employer.setTitle("DotNet Developer");
			employer.setLocation("Pune");
			employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
			employer.setMaxExp(8);
			employer.setMinExp(2);
			employer.setPrimarySkill("C# ADO.NET");
			employer.setSecSkills("Devops, Cloud Basics, React");
			employer.setStatus("Open");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", "AS16234567890");
			String role="ROLE_ADMIN";
			when(employerService.updateExistingJob(employer,1,"user")).thenReturn(employer);
			when(this.loginServiceDelegate.username("AS16234567890")).thenReturn("user");
			when(this.loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
			MvcResult mvcResult = this.mockMvc.perform(put("http://localhost:8060/employer/updatejob/1")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(employer))
			.headers(httpHeaders)
			).andExpect(status().isCreated())
			.andExpect(content().string(containsString("user")))
			.andReturn();
			
			String response = mvcResult.getResponse().getContentAsString();
			assertEquals(response.contains("user"), true);

		}
		@Test
		public void testupdatejobinvaild() throws Exception
		{
			UpdatingEmployerdto employer = new UpdatingEmployerdto();
			employer.setId(2);
			employer.setTitle("DotNet Developer");
			employer.setLocation("Pune");
			employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
			employer.setMaxExp(8);
			employer.setMinExp(2);
			employer.setPrimarySkill("C# ADO.NET");
			employer.setSecSkills("Devops, Cloud Basics, React");
			employer.setStatus("Open");
			//employer.setUserName("username");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", "AS16234567890");
			String role="ROLE_USER";
			when(employerService.updateExistingJob(employer,1,"user")).thenReturn(employer);
			when(loginServiceDelegate.username("AS16234567890")).thenReturn("user");
			when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_USER");
			MvcResult mvcResult = this.mockMvc.perform(put("http://localhost:8060/employer/updatejob/1")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(employer))
			.headers(httpHeaders)
			).andExpect(status().isBadRequest())
			.andReturn();
			

		}
	 
	 //Deletes specific job posted by logged in user
	 @Test
	    public void testdelete() throws Exception {
		    Employer employer = new Employer();
		 	employer.setId(1);
			employer.setTitle("DotNet Developer");
			employer.setLocation("Pune");
			employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
			employer.setMaxExp(8);
			employer.setMinExp(2);
			employer.setPrimarySkill("C# ADO.NET");
			employer.setSecSkills("Devops, Cloud Basics, React");
			employer.setStatus("Open");
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.set("Authorization", "AS16234567890");
	    
	        when(employerService.deleteJobById(1)).thenReturn(employer);
	        when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
	        MvcResult mvcResult = this.mockMvc.perform(delete("http://localhost:8060/employer/deletejob/1")
	                                .headers(httpHeaders))
	                                .andExpect(status().isOk())
	                                .andReturn();
	        String response = mvcResult.getResponse().getContentAsString();
	        
	        
	        
	    }
	    @Test
	    public void testdeleteinvalid() throws Exception {
	    	 	Employer employer = new Employer();
			 	employer.setId(2);
				employer.setTitle("DotNet Developer");
				employer.setLocation("Pune");
				employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
				employer.setMaxExp(8);
				employer.setMinExp(2);
				employer.setPrimarySkill("C# ADO.NET");
				employer.setSecSkills("Devops, Cloud Basics, React");
				employer.setStatus("Open");
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.set("Authorization", "AS16234567890");
	        
	        when(employerService.deleteJobById(1)).thenReturn(null);
	        when(loginServiceDelegate.role("AS16234567890")).thenReturn("ROLE_ADMIN");
	        MvcResult mvcResult = this.mockMvc.perform(delete("http://localhost:8060/employer/deletejob/1")
	                                .headers(httpHeaders))
	                                .andExpect(status().isBadRequest())
	                                .andReturn();
	        String response = mvcResult.getResponse().getContentAsString();
	            
	        
	    }
}
