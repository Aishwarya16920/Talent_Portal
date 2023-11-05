package com.zensar.tp.dto;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zensar.tp.service.JobApplicationService;

public class Testjob {

	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void testJob() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getId(),2);
    }
    
    @Test
    public void testJobprimary() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getPrimarySkill(),"java");
    }
    
    @Test
    public void testJobsecskill() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getSecSkill(),"cpp");
    }
    
    @Test
    public void testJobdescrip() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getDescription(),"Kulkarni");
    }
    
    @Test
    public void testJoblocation() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getLocation(),"anand123");
    }
    @Test
    public void testJobmax() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getMaxExp(),4);
    }
    
    @Test
    public void testJobmin() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getMinExp(),1);
    }
    
    @Test
    public void testJobtitle() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getTitle(),"java");
    }
    
    @Test
    public void testJobapplied() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getIsApplied(),false);
    }
    @Test
    public void testJobData() throws Exception {
        Job user = new Job();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkill("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setIsApplied(false);
        assertEquals(user.getCreatedDate(),null);
    }
}
