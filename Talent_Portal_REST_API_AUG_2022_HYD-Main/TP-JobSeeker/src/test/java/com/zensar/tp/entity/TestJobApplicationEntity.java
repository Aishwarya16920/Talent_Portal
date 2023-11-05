package com.zensar.tp.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(JobApplicationEntity.class)
public class TestJobApplicationEntity {

	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void teststatusid() throws Exception {
    	JobApplicationEntity user = new JobApplicationEntity();
        user.setId(5);
        user.setUserName("saketh");
        user.setApplicationStatus(null);
        user.setJob(null);
        assertEquals(user.getId(),5);
    }
    
    @Test
    public void teststatususername() throws Exception {
    	JobApplicationEntity user = new JobApplicationEntity();
        user.setId(5);
        user.setUserName("saketh");
        user.setApplicationStatus(null);
        user.setJob(null);
        assertEquals(user.getUserName(),"saketh");
    }
    
    @Test
    public void teststatusApplicationstatus() throws Exception {
    	JobApplicationEntity user = new JobApplicationEntity();
        user.setId(5);
        user.setUserName("saketh");
        user.setApplicationStatus(null);
        user.setJob(null);
        assertEquals(user.getApplicationStatus(),null);
    }
    
    @Test
    public void teststatusjob() throws Exception {
    	JobApplicationEntity user = new JobApplicationEntity();
        user.setId(5);
        user.setUserName("saketh");
        user.setApplicationStatus(null);
        user.setJob(null);
        assertEquals(user.getJob(),null);
    }

}
