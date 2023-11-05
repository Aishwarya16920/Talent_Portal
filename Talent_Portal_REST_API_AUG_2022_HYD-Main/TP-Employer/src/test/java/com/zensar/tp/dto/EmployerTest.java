package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.services.EmployerService;


@WebMvcTest({Employer.class, Job.class, Job.class, UpdatingEmployerdto.class})
public class EmployerTest {
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    EmployerService employerService;
    
    @Test
    public void testEmployerDTOReturnsCorrectJson() throws Exception {
    	Employer employer = new Employer();
    	employer.setId(1);
    	employer.setLocation("Pune");
    	employer.setMaxExp(5);
    	employer.setMinExp(2);
    	employer.setSecSkills("Devops, Cloud Basics, React");
    	employer.setDescription("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage");
        employer.setPrimarySkill("C# ADO.NET");
        employer.setTitle("DotNet Developer");
        employer.setStatus("Open");
        employer.setUserName("aishu");
        employer.toString();
        assertEquals("DotNet Developer",employer.getTitle());
        
    }
    
    @Test
    public void testEmployerParameterisedArguments() throws Exception{
        Employer employer =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open","aishu");
        assertEquals(1,employer.getId());
        assertEquals("A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage",employer.getDescription());
        assertEquals("Pune",employer.getLocation());
        assertEquals(5,employer.getMaxExp());
        assertEquals(2,employer.getMinExp());
        assertEquals("C# ADO.NET",employer.getPrimarySkill());
        assertEquals("Devops, Cloud Basics, React",employer.getSecSkills());
        assertEquals("Open",employer.getStatus());
        assertEquals("DotNet Developer",employer.getTitle());
        assertEquals("aishu", employer.getUserName());
    }
    
    @Test
    public void testEmployerHashCode() throws Exception{
        Employer employer1 =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        Employer employer2 =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        assertEquals(employer1,employer2);
        assertTrue(employer1.hashCode() == employer2.hashCode());
        
    }
    
    @Test
    public void testEmployerEqualsFalse() throws Exception{
        Employer employer1 =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        Employer employer2 =  new Employer(2, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        assertFalse(employer1.equals(employer2));
        
    }
    
    @Test
    public void testEmployerEqualsTrue() throws Exception{
        Employer employer1 =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        Employer employer2 =  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
        assertTrue(employer1.equals(employer2));
        
    }
    
    @Test
    public void testEmployerEqualsNull() throws Exception{
        assertEquals(false,  new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
				"Devops, Cloud Basics, React", "Pune", "Open", "aishu").equals(null));
        
    }
     
    @Test
    public void testJobDTOReturnsCorrectJson() throws Exception {
    	Job job = new Job();
    	job.setId(1);
    	job.setIsApplied(false);
    	job.setPrimarySkill("Java");
    	job.setSecSkill("React");
    	job.setDescription("Java Developer with 3 years experience");
    	job.setLocation("Pune");
    	job.setMaxExp(5);
    	job.setMinExp(3);
    	job.setTitle("Java Developer");
    	job.toString();
        assertEquals("Java",job.getPrimarySkill());
    }
    
    @Test
    public void testJobParameterisedArguments() throws Exception{
        Job job =  new Job(2, "React", "Java", "Chennai", "FrontEnd Developer", 2, 4,
    			"Java Developer with 2 years" , null, false);
        assertEquals(2,job.getId());
        assertEquals("React", job.getPrimarySkill());
    }
    
    @Test
    public void testJobsParameterisedArguments() throws Exception{
        Job job =  new Job(2, "React", "Java", "Chennai", "FrontEnd Developer", 2, 4,
    			"Java Developer with 2 years" , null);
        assertEquals(2,job.getId());
        assertEquals("React", job.getPrimarySkill());
    }
    
    
    @Test
    public void testUpdatingEmployerDTOReturnsCorrectJson() throws Exception {
    	UpdatingEmployerdto updateEmployer = new UpdatingEmployerdto();
    	updateEmployer.setDescription("Java Developer with 6 years of experience");
    	updateEmployer.setTitle("Java Developer");
    	updateEmployer.setLocation("Chennai");
    	updateEmployer.setMaxExp(5);
    	updateEmployer.setMinExp(3);
    	updateEmployer.setPrimarySkill("Java, React");
    	updateEmployer.setSecSkills("Python");
    	updateEmployer.setStatus("Closed");
        assertEquals("Java, React", updateEmployer.getPrimarySkill());
    }
    
    @Test
    public void testUpdatingEmployerParameterisedArguments() throws Exception{
    	UpdatingEmployerdto updateEmployer = new UpdatingEmployerdto("Java Developer","Java Developer with 6 years of experience", 3, 6, "Java, React","Python", "Chennai", "Closed");
        assertEquals("Java Developer with 6 years of experience",updateEmployer.getDescription());
        assertEquals("Chennai",updateEmployer.getLocation());
        assertEquals(6,updateEmployer.getMaxExp());
        assertEquals(3,updateEmployer.getMinExp());
        assertEquals("Java, React",updateEmployer.getPrimarySkill());
        assertEquals("Python",updateEmployer.getSecSkills());
        assertEquals("Closed",updateEmployer.getStatus());
        assertEquals("Java Developer",updateEmployer.getTitle());
    }
    
    
}
