package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(Applicationstatus.class)

public class Applicationstatustest {


    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobApplicationService;
 
	@Test
    public void Testapplicationstatusid() throws Exception {
	Applicationstatus user = new Applicationstatus();
	user.setStatusId(1);
	user.setStatus("Applied");
           
        assertEquals(user.getStatusId(),1);
    }
	@Test
    public void Testapplicationstatus() throws Exception {
	Applicationstatus user = new Applicationstatus();
	user.setStatusId(6);
	user.setStatus("Rejected");
        
        
        assertEquals(user.getStatus(),"Rejected");
    }
}