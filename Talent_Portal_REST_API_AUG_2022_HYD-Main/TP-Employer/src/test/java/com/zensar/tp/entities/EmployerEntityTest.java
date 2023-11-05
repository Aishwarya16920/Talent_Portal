package com.zensar.tp.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.services.EmployerService;


@WebMvcTest({JobEntity.class,JobApplicationEntity.class, ApplicationStatus.class})
public class EmployerEntityTest {
		@Autowired
	    MockMvc mockMvc;
	    
	    @MockBean
	    EmployerService employerService;
	    
	    @Test
	    public void testJobReturnsCorrectJson() throws Exception {
	    	JobEntity job = new JobEntity();
	    	job.setId(1);
	    	job.setLocation("Pune");
	    	job.setMaxExp(5);
	    	job.setMinExp(2);
	    	job.setSecSkills("Devops, Cloud Basics, React");
	    	job.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
	        job.setPrimarySkill("C# ADO.NET");
	        job.setTitle("DotNet Developer");
	        job.setStatus("Open");
	        job.setModifiedDate(null);
	        job.setCreatedDate(null);
	        job.setUsername("aishu");
	        job.setStatusId(5);
	        job.toString();
	        assertEquals("DotNet Developer",job.getTitle());
	        assertEquals(null,job.getModifiedDate());
	        assertEquals(null,job.getCreatedDate());
	        assertEquals("aishu",job.getUsername());
	        assertEquals(5,job.getStatusId());
	        
	    }
	    
	    @Test
	    public void testJobParameterisedArguments() throws Exception{
	        JobEntity employer =  new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
					"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
	        assertEquals("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage",employer.getDescription());
	        assertEquals("Pune",employer.getLocation());
	        assertEquals(5,employer.getMaxExp());
	        assertEquals(2,employer.getMinExp());
	        assertEquals("C# ADO.NET",employer.getPrimarySkill());
	        assertEquals("Devops, Cloud Basics, React",employer.getSecSkills());
	        assertEquals("Open",employer.getStatus());
	        assertEquals("DotNet Developer",employer.getTitle());
	        assertEquals("aishu",employer.getUsername());
	    }
	    
	    @Test
	    public void testJobsParameterisedArguments() throws Exception{
	        JobEntity employer =  new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
					"Devops, Cloud Basics, React", "Pune", null);
	        assertEquals("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage",employer.getDescription());
	        assertEquals("Pune",employer.getLocation());
	        assertEquals(5,employer.getMaxExp());
	        assertEquals(2,employer.getMinExp());
	        assertEquals("C# ADO.NET",employer.getPrimarySkill());
	        assertEquals("Devops, Cloud Basics, React",employer.getSecSkills());
	        assertEquals("DotNet Developer",employer.getTitle());
	        assertEquals(null,employer.getCreatedDate());
	    }
	    
	    @Test
	    public void testJobSkillParameterisedArguments() throws Exception{
	        JobEntity employer =  new JobEntity(1, "DotNet Developer");
	        assertEquals(1,employer.getId());
	        assertEquals("DotNet Developer",employer.getPrimarySkill());
	    }
	    
	    @Test
	    public void testJobApplicationEntityReturnsCorrectJson() throws Exception {
	    	JobApplicationEntity job = new JobApplicationEntity();
	    	job.setId(1);
	    	job.setJobId(2);
	    	job.setUserName("aishu");
	        job.toString();
	        assertEquals(1,job.getId());
	        assertEquals(2,job.getJobId());
	        assertEquals("aishu",job.getUserName());
	        
	    }
	    
	    @Test
	    public void testJobApplicationEntityParameterisedArguments() throws Exception{
	    	JobEntity jobEntity = new JobEntity(23, "Python");
	    	JobApplicationEntity jobApplicationEntity = new JobApplicationEntity(16, "aishu",jobEntity);
	        assertEquals(16, jobApplicationEntity.getId());
	        assertEquals("aishu", jobApplicationEntity.getUserName());
	        assertEquals(23, jobEntity.getId());
	        assertEquals("Python", jobEntity.getPrimarySkill());
	    }
	    
	    
	    @Test
	    public void testApplicationStatusReturnsCorrectJson() throws Exception {
	    	ApplicationStatus applicationStatus = new ApplicationStatus();
	    	applicationStatus.setStatusId(5);
	    	applicationStatus.setStatus("Rejected");
	    	applicationStatus.toString();
	        assertEquals("Rejected", applicationStatus.getStatus());
	    }
	    
	    @Test
	    public void testApplicationStatusParameterisedArguments() throws Exception{
	    	ApplicationStatus applicationStatus = new ApplicationStatus(5,"Selected");
	        assertEquals(5,applicationStatus.getId());
	        assertEquals("Selected", applicationStatus.getStatus());
	    }
	    
	    @Test
	    public void testUserEntityReturnsCorrectJson() throws Exception {
	    	UserDetails user = new UserDetails();
	    	user.setId(1);
	    	user.setEmail("user@gmail.com");
	    	user.setFirstName("Aishwarya");
	    	user.setLastName("M");
	    	user.setPassword("user123");
	    	user.setPhone("9987762826");
	    	user.setUsername("aishu123");
	    	user.setRole("admin");
	    	user.toString();
	        assertEquals("Aishwarya", user.getFirstName());
	        assertEquals("admin", user.getRole());
	    }
	    
	    @Test
	    public void testUserParameterisedArguments() throws Exception{
	    	UserDetails user = new UserDetails(1, "Aishwarya", "M", "aishu123", "user123", "user@gmail.com","9987762826");
	        assertEquals(1,user.getId());
	        assertEquals("user@gmail.com",user.getEmail());
	        assertEquals("Aishwarya",user.getFirstName());
	        assertEquals("M",user.getLastName());
	        assertEquals("user123",user.getPassword());
	        assertEquals("9987762826",user.getPhone());
	        assertEquals("aishu123",user.getUsername());
	    }
	    
	    @Test
	    public void testUserWithoutIdParameterisedArguments() throws Exception{
	    	UserDetails user = new UserDetails("Aishwarya", "M", "aishu123", "user123", "user@gmail.com","9987762826");
	        assertEquals("user@gmail.com",user.getEmail());
	        assertEquals("Aishwarya",user.getFirstName());
	        assertEquals("M",user.getLastName());
	        assertEquals("user123",user.getPassword());
	        assertEquals("9987762826",user.getPhone());
	        assertEquals("aishu123",user.getUsername());
	    }
	    
	    

}