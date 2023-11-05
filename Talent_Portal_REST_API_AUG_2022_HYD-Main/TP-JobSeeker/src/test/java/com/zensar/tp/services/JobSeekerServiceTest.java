package com.zensar.tp.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.ApplicantsDto;
import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.dto.JobStatus;
import com.zensar.tp.dto.JobsApplied;
import com.zensar.tp.entity.ApplicationStatusEntity;
import com.zensar.tp.entity.JobApplication;
import com.zensar.tp.entity.JobApplicationEntity;
import com.zensar.tp.entity.JobEntity;
import com.zensar.tp.repo.JobApplicationRepo;
import com.zensar.tp.repo.JobApplicationStatusRepo;
import com.zensar.tp.repo.JobRepository;
import com.zensar.tp.repo.ApplicationStatusRepo;
import com.zensar.tp.service.JobApplicationService;
import com.zensar.tp.service.JobApplicationServiceImpl;
import com.zensar.tp.service.LoginServiceDelegate;

@WebMvcTest(JobApplicationServiceImpl.class)
public class JobSeekerServiceTest {
	 
	
	@Autowired
	  MockMvc mockMvc;
	@MockBean
	LoginServiceDelegate loginServiceDelegate;
	
	
	
	@Autowired
	 JobApplicationService jobApplicationService;
	 @MockBean
	   JobApplicationRepo jobRepo;
	 @MockBean
	 ApplicationStatusRepo statusrepo;
	 @MockBean
	 JobRepository jobRepository;
	 @MockBean
	 JobApplicationStatusRepo jobApplicationStatusRepo;
	   @Autowired
	    ObjectMapper objectMapper;
	   
	   @Test
	    public void testGetStatusByid() throws Exception{
		   
		   List<JobApplicationEntity> jobApplication=new ArrayList<>();
		   JobEntity Job=new JobEntity("title", "user", 0, 0, "user", "user", "user", "user");
		   Job.setId(1);
		   ApplicationStatusEntity ApplicationStatus=new ApplicationStatusEntity(1,"open");
		   jobApplication.add(new JobApplicationEntity(1,"user",Job,ApplicationStatus));
		   when(this.jobRepo.findByUserName("user")).thenReturn(jobApplication);
		   JobApplicationEntity jobApplicationlist=new JobApplicationEntity(1, null, null, null);
		   List<JobStatus> lis=new ArrayList<>();
		   List<JobStatus> list= jobApplicationService.getbyjobStatus("user");
		   for(JobApplicationEntity i:jobApplication) {
				JobStatus status=new JobStatus(i.getId(),i.getJob().getId(),i.getUserName(),i.getApplicationStatus().getStatus(),i.getJob().getTitle(),i.getJob().getLocation());
				list.add(status);
			}
		    JobApplicationEntity jobEntity=new JobApplicationEntity();
		    
		   
	   }
	  
       @Test
	    public void testSearchById() throws Exception{
    	   List<JobEntity> search=new ArrayList<>();
    	   List<JobEntity> list=jobApplicationService.findBySkill("");
    	   when(this.jobRepository.findByprimarySkill("")).thenReturn(search);
       }
       @Test
       public void getbyuserStatus() throws Exception{
    	   List<ApplicantsDto> list=jobApplicationService.getbyuserStatus("user");
    	   List<JobApplicationEntity> jobApplicationEntity=new ArrayList<>();
    	   when(this.jobRepo.findAll()).thenReturn(jobApplicationEntity);
    	   List<ApplicantsDto> Applicants=new ArrayList<>();
//    	   for(JobApplicationEntity i:jobApplicationEntity) {
    		   
    	   
       }
//       @Test
//       public void postJobuser() throws Exception{
//    	   JobApplicationDto jobApplication=new JobApplicationDto("user", 1, 1, 1);
//    	   
//    	  
//    	   JobEntity jobEntity=new JobEntity("user", "user", 1, 1, "user", "user", "user","user");
//    	   JobApplication applicationStatusEntity=new JobApplication(1, "user", 1, 1);
//    	   ApplicationStatusEntity applicationStatus=new ApplicationStatusEntity(1, "user");
//    	   JobApplicationEntity jobApplicationEntity=new JobApplicationEntity(1, "user", jobEntity, applicationStatus);
//    	  
//    	   when(this.jobRepository.existsById(1)).thenReturn(true);
//    	   when(this.jobRepository.getById(1)).thenReturn(jobEntity);
//    	   when(this.jobApplicationStatusRepo.getById(1)).thenReturn(applicationStatusEntity);
//    	   
//    	   when(this.jobRepo.save(jobApplicationEntity)).thenReturn(jobApplicationEntity);
//    	   jobApplication=new JobApplicationDto("user", 1, 1, 1);
//    	   JobApplicationDto jobApplications=jobApplicationService.postJob(jobApplication);
//    	  
//       }
}