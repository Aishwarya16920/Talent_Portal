package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(JobsApplied.class)
public class TestJobsApplied {
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void testjobsapplied() throws Exception {
    	JobsApplied user = new JobsApplied();
        user.setId(2);
        user.setSkill("java");
        assertEquals(user.getId(),2);
    }
    
    @Test
    public void testjobsapplied_skill() throws Exception {
    	JobsApplied user = new JobsApplied();
        user.setId(2);
        user.setSkill("java");
        assertEquals(user.getSkill(),"java");
    }
    
    @Test
    public void testGetalljobsapplied() throws Exception{
    	JobsApplied user =  new JobsApplied(2,"java");
        assertEquals(user.getId(),2);
        assertEquals(user.getSkill(),"java");
        
    }
    
    @Test
    public void testtostring() throws Exception{
    	JobsApplied user =  new JobsApplied(2,"java");
    	String userDto=user.toString();
    	assertEquals(user.toString(),userDto);
    	
    	
    }
}