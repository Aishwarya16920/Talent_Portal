package com.zensar.tp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import com.zensar.tp.dto.Employer;
import com.zensar.tp.dto.Job;
import com.zensar.tp.dto.UpdatingEmployerdto;
import com.zensar.tp.entities.JobApplicationEntity;
import com.zensar.tp.entities.JobEntity;
import com.zensar.tp.entities.UserDetails;
import com.zensar.tp.exceptions.InvalidException;
import com.zensar.tp.repository.JobRepository;
import com.zensar.tp.repository.JobApplicationRepo;

@Service


public class EmployerServiceImpl implements EmployerService{
	
	@Autowired
	private JobRepository employerRepository;
	
	@Autowired
	JobApplicationRepo jobApplicationRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	//Post a new Job
	@Override
	public Employer postNewJob(Employer employer, String userName) {
		if((employer.getLocation() != null) && (employer.getPrimarySkill() != null) && (employer.getSecSkills() != null) && employer.getTitle() != null && (employer.getDescription() != null)) {
			employer.setStatus("Open");
			employer.setUserName(userName);
			JobEntity employerEntity =  new JobEntity(employer.getTitle(), employer.getDescription(), employer.getMinExp(), employer.getMaxExp(), employer.getPrimarySkill(), employer.getSecSkills(), employer.getLocation(), employer.getStatus(), employer.getUserName());
			employerEntity = employerRepository.save(employerEntity);
			employer = new Employer(employerEntity.getId(),employerEntity.getTitle(), employerEntity.getDescription(), employerEntity.getMinExp(), employerEntity.getMaxExp(), employerEntity.getPrimarySkill(), employerEntity.getSecSkills(), employerEntity.getLocation(), employerEntity.getStatus(), employerEntity.getUsername());
			return  employer;
		}
		throw new InvalidException("Invalid User");
	}

	//List of all jobs in portal
	@Override
    public List<Job> getAllJobs() {
        List<JobEntity> jobEntityList = employerRepository.findAll();
        List<Job> jobDtoList = new ArrayList<>();
        for(JobEntity jobEntity: jobEntityList) {
            Job job = new Job(jobEntity.getId(),jobEntity.getPrimarySkill(),jobEntity.getSecSkills(),jobEntity.getLocation(),jobEntity.getTitle(),jobEntity.getMinExp(),jobEntity.getMaxExp(),jobEntity.getDescription(),jobEntity.getCreatedDate());
            jobDtoList.add(job);
            
        }
        return jobDtoList;
    }
	
	@Override
    public List<Job> getAllJobsWithApplicationStatus(String username) {
        List<JobEntity> jobEntityList = employerRepository.findAll();
        List<Job> jobDtoList = new ArrayList<>();
        for(JobEntity jobEntity: jobEntityList) {
            Boolean isApplied =jobApplicationRepository.existsByUserNameAndJobId(username, jobEntity.getId());
                    
            Job job = new Job(jobEntity.getId(),jobEntity.getPrimarySkill(),jobEntity.getSecSkills(),jobEntity.getLocation(),jobEntity.getTitle(),jobEntity.getMinExp(),jobEntity.getMaxExp(),jobEntity.getDescription(),jobEntity.getCreatedDate(), isApplied);
            jobDtoList.add(job);
            }
            
        return jobDtoList;
        
    }
	
	//Read all jobs posted by employer
	@Override
	public List<Employer> readAllJobs(String userName) {
		List<JobEntity> entity = employerRepository.findByUsername(userName);
		return entity.stream().map(i-> mapper.map(i, Employer.class)).collect(Collectors.toList());
	}
	
	
	//Updates an existing job
	@Override
	public UpdatingEmployerdto updateExistingJob(UpdatingEmployerdto employer,int id,String userName){
		
		if((employer.getLocation() != null) && (employer.getPrimarySkill() != null) && (employer.getSecSkills() != null) && employer.getTitle() != null && (employer.getDescription() != null)) {
			if(employerRepository.existsById(id)) {
				
				JobEntity employerEntity =  new JobEntity(employer.getTitle(), employer.getDescription(), employer.getMinExp(), employer.getMaxExp(), employer.getPrimarySkill(), employer.getSecSkills(), employer.getLocation(), employer.getStatus(), employer.getUserName());
				UserDetails user;
				
				employerEntity.setId(id);
				employerEntity.setUsername(userName);
				employerEntity.setModifiedDate(employer.getModifiedDate());
				employerEntity = employerRepository.save(employerEntity);
				employer = new UpdatingEmployerdto(employerEntity.getTitle(), employerEntity.getDescription(), employerEntity.getMaxExp(),  employerEntity.getMinExp(),employerEntity.getPrimarySkill(), employerEntity.getSecSkills(), employerEntity.getLocation(), employerEntity.getStatus());
				employer.setId(id);
				employer.setUserName(userName);
				return  employer;
			}
			
			throw new InvalidException("Invalid Id");
		}
		throw new InvalidException("Invalid User");
	}
	
	//Deletes specific job posted by logged in user
	@Override
    public Employer deleteJobById(int id) {
		
			
		
        if(employerRepository.existsById(id)) {
        	List<JobApplicationEntity> jobApplicationEntity =jobApplicationRepository.findByJobId(id);
        	
        	jobApplicationRepository.deleteAll(jobApplicationEntity);
        	JobEntity empEntity = employerRepository.getById(id);
        	Employer empDto = mapper.map(empEntity,Employer.class);
            employerRepository.delete(empEntity);
            return empDto;
        }
        return null;
    }
	
	
	
}
