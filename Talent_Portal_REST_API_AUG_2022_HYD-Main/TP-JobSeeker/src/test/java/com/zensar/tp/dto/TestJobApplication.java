package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;


@WebMvcTest(JobStatus.class)
public class TestJobApplication {
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void testPostJobPortal() throws Exception {
    	JobStatus user = new JobStatus();
        user.setId(2);
        user.setJobId(3);
        user.setUserName("anand");
        user.setStatus("Applied");
        user.setTitle("dotnet");
        user.setLocation("Pune");
        assertEquals(user.getUserName(),"anand");
    }
    
    @Test
    public void testPostJobPortalstatus() throws Exception {
    	JobStatus user = new JobStatus();
        user.setId(2);
        user.setJobId(3);
        user.setUserName("anand");
        user.setStatus("Applied");
        user.setTitle("dotnet");
        user.setLocation("Pune");
        assertEquals(user.getStatus(),"Applied");
    }
    
    @Test
    public void testPostJobPortaltitle() throws Exception {
    	JobStatus user = new JobStatus();
        user.setId(2);
        user.setJobId(3);
        user.setUserName("anand");
        user.setStatus("Applied");
        user.setTitle("dotnet");
        user.setLocation("Pune");
        assertEquals(user.getTitle(),"dotnet");
    }
    
    @Test
    public void testPostJobPortallocation() throws Exception {
    	JobStatus user = new JobStatus();
        user.setId(2);
        user.setJobId(3);
        user.setUserName("anand");
        user.setStatus("Applied");
        user.setTitle("dotnet");
        user.setLocation("Pune");
        assertEquals(user.getLocation(),"Pune");
    }
    
    @Test
    public void testPostJobPortaljobid() throws Exception {
    	JobStatus user = new JobStatus();
        user.setId(2);
        user.setJobId(3);
        user.setUserName("anand");
        user.setStatus("Applied");
        user.setTitle("dotnet");
        user.setLocation("Pune");
        assertEquals(user.getJobId(),3);
    }
    
    
}

