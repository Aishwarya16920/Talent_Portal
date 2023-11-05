package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

@WebMvcTest(JobsApplied.class)
public class JobSeekerTest {
	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobApplicationService;
    
    @Test
    public void testApplicantsDto() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getSkill(),"java");
    }
    
    @Test
    public void testApplicantsDtostatusid() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getStatus_id(),"Applied");
    }
    
    
    @Test
    public void testApplicantsDtousername() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getUser_name(),"saketh");
    }
    @Test
    public void testbApplicantsDtostatusid() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getStatus_id(),"Applied");
    }
    
    @Test
    public void testbApplicantsDtoid() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getSkill(),"java");
    }
    
    @Test
    public void testbApplicantsDtoname() throws Exception {
        ApplicantsDto user = new ApplicantsDto();
        user.setSkill("java");
        user.setStatus_id("Applied");
        user.setUser_name("saketh");
        assertEquals(user.getUser_name(),"saketh");
    }
    
  
}

