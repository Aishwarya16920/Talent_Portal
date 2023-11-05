package com.zensar.tp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.tp.dto.ApplicantsDto;
import com.zensar.tp.dto.Applicationstatus;
import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.dto.JobStatus;
import com.zensar.tp.dto.JobsApplied;
import com.zensar.tp.entity.ApplicationStatusEntity;
import com.zensar.tp.entity.JobApplication;
import com.zensar.tp.entity.JobApplicationEntity;
import com.zensar.tp.entity.JobEntity;
import com.zensar.tp.exceptions.InvalidUserDataException;
import com.zensar.tp.repo.ApplicationStatusRepo;
import com.zensar.tp.repo.JobApplicationRepo;
import com.zensar.tp.repo.JobApplicationStatusRepo;
import com.zensar.tp.repo.JobRepository;
import com.zensar.tp.service.JobApplicationService;


@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	
	@Autowired 
	ApplicationStatusRepo statusRepo;
	@Autowired 
	JobApplicationRepo jobApplicationRepo;
	@Autowired
	JobRepository jobsRepo;
	@Autowired
	JobApplicationStatusRepo jobApplicationStatusRepo;
	
	
	ModelMapper mapper=new ModelMapper();
	
	
	@Override
	public List<JobEntity> findBySkill(String primaySkill){
		
		List<JobEntity> search=jobsRepo.findByprimarySkill(primaySkill);
		return search;
	}
	
	

	@Override
	public JobApplicationDto postJob(JobApplicationDto jobApplication) {
        JobApplicationEntity jobApplicationEntity=mapper.map(jobApplication,JobApplicationEntity.class);
        if(jobsRepo.existsById(jobApplicationEntity.getJob().getId())){
        	
        JobEntity jobEntity=jobsRepo.getById(jobApplicationEntity.getJob().getId());  
        ApplicationStatusEntity applicationStatusEntity=statusRepo.getById(jobApplicationEntity.getApplicationStatus().getStatusId());
        jobApplicationEntity.setApplicationStatus(applicationStatusEntity);
        jobApplicationEntity.setJob(jobEntity);
        jobApplicationEntity=jobApplicationRepo.save(jobApplicationEntity);
        jobApplication=mapper.map(jobApplicationEntity, JobApplicationDto.class);
		return jobApplication;
        }
        
throw new InvalidUserDataException("Invaild job id");
    
}
	@Override
	public List<JobStatus> getbyjobStatus(String username) {
		List<JobApplicationEntity> jobApplicationEntity=jobApplicationRepo.findByUserName(username);
		List<JobStatus> jobStatus=new ArrayList<>();
		for(JobApplicationEntity i:jobApplicationEntity) {
			JobStatus status=new JobStatus(i.getId(),i.getJob().getId(),i.getUserName(),i.getApplicationStatus().getStatus(),i.getJob().getTitle(),i.getJob().getLocation());
			jobStatus.add(status);
		}
		return jobStatus;
	}
	@Override
    public List<ApplicantsDto> getbyuserStatus(String username) {
        List<JobApplicationEntity> jobApplicationEntity=jobApplicationRepo.findAll();
        List<ApplicantsDto> Applicants=new ArrayList<>();
        for(JobApplicationEntity i: jobApplicationEntity) {
            if(i.getJob().getUsername().equals(username)) {
            
                ApplicantsDto applicants=new ApplicantsDto(i.getId(),i.getJob().getId(),i.getJob().getPrimarySkill(),i.getApplicationStatus().getStatus(),i.getUserName());
            Applicants.add(applicants);
            }
        }
        return Applicants;
    }



	@Override
	public JobApplication updateuserStatus(JobApplication applicants,String username) {
		
		List<JobApplicationEntity> jobApplicationEntity=jobApplicationRepo.findAll();
		
		for(JobApplicationEntity i: jobApplicationEntity) {
			if(i.getJob().getUsername().equals(username)) {
				if(i.getUserName().equals(applicants.getUserName()) && i.getJob().getId()==applicants.getJobId()) {
					applicants.setId(i.getId());
					jobApplicationStatusRepo.save(applicants);
			}
		}
	}
		return applicants;
	}
}

