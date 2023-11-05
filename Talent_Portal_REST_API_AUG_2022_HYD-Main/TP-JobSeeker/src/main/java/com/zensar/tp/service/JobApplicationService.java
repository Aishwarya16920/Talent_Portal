package com.zensar.tp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.tp.dto.ApplicantsDto;
import com.zensar.tp.dto.Applicationstatus;
import com.zensar.tp.dto.JobApplicationDto;
import com.zensar.tp.dto.JobStatus;
import com.zensar.tp.dto.JobsApplied;
import com.zensar.tp.entity.JobApplication;
import com.zensar.tp.entity.JobApplicationEntity;
import com.zensar.tp.entity.JobEntity;



public interface JobApplicationService { 

	public JobApplicationDto postJob(JobApplicationDto user);
	public List<JobStatus> getbyjobStatus(String username);
	public List<ApplicantsDto> getbyuserStatus(String username);
	List<JobEntity> findBySkill(String primaryskill);
	public JobApplication updateuserStatus(JobApplication applicants,String username);
}