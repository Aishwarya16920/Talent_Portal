package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

public class TestApplicantsDto {
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobApplicationService;
		
	    
	    @Test
	    public void testbApplicationDto() throws Exception {
	        JobApplicationDto user = new JobApplicationDto();
	        user.setUserName("anand");
	        user.setId(2);
	        user.setJobId(11);
	        user.setStatusId(1);
	        assertEquals(user.getUserName(),"anand");
	    }
	    
	    @Test
	    public void testbApplicationDtoid() throws Exception {
	        JobApplicationDto user = new JobApplicationDto();
	        user.setUserName("anand");
	        user.setId(2);
	        user.setJobId(11);
	        user.setStatusId(1);
	        assertEquals(user.getId(),2);
	    }
	    
	    
	    @Test
	    public void testbApplicationDtojobid() throws Exception {
	        JobApplicationDto user = new JobApplicationDto();
	        user.setUserName("anand");
	        user.setId(2);
	        user.setJobId(11);
	        user.setStatusId(1);
	        assertEquals(user.getJobId(),11);
	    }
	    
	    @Test
	    public void testbApplicationDtostatusid() throws Exception {
	        JobApplicationDto user = new JobApplicationDto();
	        user.setUserName("anand");
	        user.setId(2);
	        user.setJobId(11);
	        user.setStatusId(1);
	        assertEquals(user.getStatusId(),1);
	    }
	    
	    
	    

}
