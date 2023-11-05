package com.zensar.tp.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(JobApplication.class)
public class TestEntity {
	
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void testid() throws Exception {
    	JobApplication user = new JobApplication();
    	user.setId(1);
    	user.setUserName("saketh");
    	user.setJobId(11);
        user.setStatusId(5);
        
        assertEquals(user.getId(),1);
    }
    
    @Test
    public void testusername() throws Exception {
    	JobApplication user = new JobApplication();
    	user.setId(1);
    	user.setUserName("saketh");
    	user.setJobId(11);
        user.setStatusId(5);
        
        assertEquals(user.getUserName(),"saketh");
    }
    
    @Test
    public void testjobid() throws Exception {
    	JobApplication user = new JobApplication();
    	user.setId(1);
    	user.setUserName("saketh");
    	user.setJobId(11);
        user.setStatusId(5);
        
        assertEquals(user.getJobId(),11);
    }
    
    @Test
    public void teststatusid() throws Exception {
    	JobApplication user = new JobApplication();
    	user.setId(1);
    	user.setUserName("saketh");
    	user.setJobId(11);
        user.setStatusId(5);
        
        assertEquals(user.getStatusId(),5);
    }
}