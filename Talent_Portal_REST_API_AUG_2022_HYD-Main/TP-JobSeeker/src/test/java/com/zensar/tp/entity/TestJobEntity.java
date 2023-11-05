package com.zensar.tp.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.zensar.tp.service.JobApplicationService;

public class TestJobEntity {

	@Autowired
    MockMvc mockMvc;
    
    @MockBean
    JobApplicationService jobService;
    
    @Test
    public void testJob() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getId(),2);
    }
    
    @Test
    public void testJobprimskill() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getPrimarySkill(),"java");
    }
    
    @Test
    public void testJobsecskills() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getSecSkills(),"cpp");
    }
    
    @Test
    public void testJobdescript() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getDescription(),"Kulkarni");
    }
    
    @Test
    public void testJobCreate() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getCreatedDate(),null);
    }
    
    @Test
    public void testJobLocate() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("Pune");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getLocation(),"Pune");
    }
    
    @Test
    public void testJobmax() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getMaxExp(),4);
    }
    
    @Test
    public void testJobmin() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getMinExp(),1);
    }
    
    @Test
    public void testJobtitle() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getTitle(),"java");
    }
    
    @Test
    public void testJobmodify() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getModifiedDate(),null);
    }
    
    @Test
    public void testJobstatus() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getStatus(),"Applied");
    }
    
    @Test
    public void testJobstatusid() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getStatusId(),1);
    }
    
    @Test
    public void testJobusername() throws Exception {
        JobEntity user = new JobEntity();
        user.setId(2);
        user.setPrimarySkill("java");
        user.setSecSkills("cpp");
        user.setDescription("Kulkarni");
        user.setCreatedDate(null);
        user.setLocation("anand123");
        user.setMaxExp(4);
        user.setMinExp(1);
        user.setTitle("java");
        user.setModifiedDate(null);
        user.setStatus("Applied");
        user.setStatusId(1);
        user.setUsername("saketh");
        assertEquals(user.getUsername(),"saketh");
    }
}