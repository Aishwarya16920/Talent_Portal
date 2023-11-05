package com.zensar.tp.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(JobApplication.class)
public class Test_Entity {
	
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void teststatusid() throws Exception {
        ApplicationStatusEntity user = new ApplicationStatusEntity();
        user.setStatusId(5);
        user.setStatus("Rejected");
        assertEquals(user.getStatusId(),5);
    }
    
    @Test
    public void teststatus() throws Exception {
        ApplicationStatusEntity user = new ApplicationStatusEntity();
        user.setStatusId(5);
        user.setStatus("Rejected");
        assertEquals(user.getStatus(),"Rejected");
    }
}

