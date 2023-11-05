package com.zensar.tp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.tp.dto.Employer;
import com.zensar.tp.dto.Job;
import com.zensar.tp.dto.UpdatingEmployerdto;

@Service
public interface EmployerService {
	
	//Post a new Job
	public Employer postNewJob(Employer employer, String userName);
	
	//List of all jobs in portal
	public List<Job> getAllJobs();
	public List<Job> getAllJobsWithApplicationStatus(String username);
	
	//Read all jobs posted by employer
	public List<Employer> readAllJobs(String userName);
	
	//Updates an existing job
	public UpdatingEmployerdto updateExistingJob(UpdatingEmployerdto updateEmployer,int id,String userName);
	
	//Deletes specific job posted by logged in user
	public Employer deleteJobById(int id);
}
