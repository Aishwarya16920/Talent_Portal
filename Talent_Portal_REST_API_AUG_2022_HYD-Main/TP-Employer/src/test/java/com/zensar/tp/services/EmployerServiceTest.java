package com.zensar.tp.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.dto.Employer;
import com.zensar.tp.dto.Job;
import com.zensar.tp.dto.UpdatingEmployerdto;
import com.zensar.tp.entities.JobApplicationEntity;
import com.zensar.tp.entities.JobEntity;
import com.zensar.tp.repository.JobApplicationRepo;
import com.zensar.tp.repository.JobRepository;

@WebMvcTest(EmployerServiceImpl.class)
public class EmployerServiceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	EmployerService employerService;
	
	@MockBean
	JobRepository employerRepository;
	
	@MockBean
	JobApplicationRepo jobApplicationRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	ModelMapper mapper = new ModelMapper();
	
	//Post a new Job
	@Test
	public void testPostNewJob() throws Exception{
		Employer employer = new Employer(1, "DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET", "Devops, Cloud Basics, React", "Pune", "Open", "aishu");
		JobEntity employerEntity = new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET", "Devops, Cloud Basics, React", "Pune", "Open", "aishu");
		employerEntity.setId(1);
		String username = employer.getUserName();
		when(employerRepository.save(any())).thenReturn(employerEntity);
		Employer returnedEmployer = employerService.postNewJob(employer, username);
		assertEquals(employerEntity.getId(), returnedEmployer.getId());
	}
	
	//List of all jobs in portal
	@Test
	public void testgetAllJobs() {
		List<JobEntity> list=new ArrayList<>();
		list.add(new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET","Devops, Cloud Basics, React", "Pune", "Open", "aishu"));
		list.add(new JobEntity("Java Developer", "A Java Developer minimum 5 years’ experience.", 3, 6, "Java, React","Cloud Basics", "Chennai", "Closed", "aishu"));
	    when(employerRepository.findAll()).thenReturn(list);
		List<Job> dto = new ArrayList<>();
		dto.add(new Job(1, "React", "Java", "Chennai", "FrontEnd Developer", 2, 4,
    			"FrontEnd Developer with 2 years" , null));
		dto.add(new Job(2, "Java", "Python", "Pune", "Java Developer", 3, 5,
    			"Java Developer with 3 years" , null));
		when(employerService.getAllJobs()).thenReturn(dto);
	}
	
	@Test
	public void testgetAllJobsWithApplicationStatus() {
		List<JobEntity> list=new ArrayList<>();
		String username = "aishu";
		list.add(new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET","Devops, Cloud Basics, React", "Pune", "Open", username));
		list.add(new JobEntity("Java Developer", "A Java Developer minimum 5 years’ experience.", 3, 6, "Java, React","Cloud Basics", "Chennai", "Closed", username));
	    employerRepository.findAll();
		List<Job> dto = new ArrayList<>();
		dto.add(new Job(1, "React", "Java", "Chennai", "FrontEnd Developer", 2, 4,
    			"Java Developer with 2 years" , null, false));
		dto.add(new Job(2, "Java", "Python", "Pune", "Java Developer", 3, 5,
    			"Java Developer with 3 years" , null, false));
		when(jobApplicationRepository.existsByUserNameAndJobId(username, 1)).thenReturn(false);
		when(employerService.getAllJobsWithApplicationStatus(username)).thenReturn(dto);
	}
	
	
	
	//Read all jobs posted by employer
	@Test
	public void testReadAllJobs() {
		List<JobEntity> readList = new ArrayList<>();
		readList.add(new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET","Devops, Cloud Basics, React", "Pune", "Open", "aishu"));
		readList.add(new JobEntity("Java Developer", "A Java Developer minimum 5 years’ experience.", 3, 6, "Java, React","Cloud Basics", "Chennai", "Closed", "aishu"));
		when(employerRepository.findAll()).thenReturn(readList);
		when(employerService.readAllJobs("aishu")).thenReturn(readList.stream().map(i-> mapper.map(i, Employer.class)).collect(Collectors.toList()));
		assertEquals("DotNet Developer",readList.get(0).getTitle());
		
	}
	
	//Updates an existing job
	@Test
	public void testUpdateExistingJob() {
		UpdatingEmployerdto employer = new UpdatingEmployerdto("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 5, 2, "C# ADO.NET", "Devops, Cloud Basics, React", "Pune", "Open");
		JobEntity employerEntity = new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET", "Devops, Cloud Basics, React", "Pune", "Open", "aishu");
		employerEntity.setId(1);
		employerEntity.setUsername("Aishu");
		Date date = new Date(System.currentTimeMillis());
		employerEntity.setModifiedDate(date);
		when(employerRepository.existsById(1)).thenReturn(true);
		when(employerRepository.save(any())).thenReturn(employerEntity);
		employer.setId(1);
		employer.setUserName("aishu");
		UpdatingEmployerdto returnedEmployer = employerService.updateExistingJob(employer,employer.getId(),employer.getUserName());
		assertEquals(employerEntity.getId(), returnedEmployer.getId());
	}
	
	//Deletes specific job posted by logged in user
	@Test
	public void testDeleteByJobId() {
		JobEntity jobEntity = new JobEntity("DotNet Developer", "A dot net developer minimum 5 years’ experience. Having experience in FED will be an added advantage", 2, 5, "C# ADO.NET",
					"Devops, Cloud Basics, React", "Pune", "Open", "aishu");
		List<JobApplicationEntity> jobList = new ArrayList<>();
		jobList.add(new JobApplicationEntity(16, "aishu",jobEntity));
		when(jobApplicationRepository.findByJobId(1)).thenReturn(jobList);
		jobApplicationRepository.deleteAll(jobList);
		when(employerRepository.existsById(1)).thenReturn(true);
		when(employerRepository.getById(1)).thenReturn(jobEntity);
		Employer empDto = mapper.map(jobEntity,Employer.class);
		employerRepository.delete(jobEntity);
		employerService.deleteJobById(1);
		when(employerRepository.existsById(2)).thenReturn(false);
	}
}
