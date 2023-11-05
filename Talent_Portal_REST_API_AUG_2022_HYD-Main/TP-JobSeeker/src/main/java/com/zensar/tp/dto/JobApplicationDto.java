package com.zensar.tp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

@Component
public class JobApplicationDto {
    private String userName;
    private int id;
    private int jobId;
    private int statusId;
   
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public JobApplicationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobApplicationDto(String userName, int id, int jobId, int statusId) {
		super();
		this.userName = userName;
		this.id = id;
		this.jobId = jobId;
		this.statusId = statusId;
	}
	@Override
	public String toString() {
		return "JobApplicationDto [userName=" + userName + ", id=" + id + ", jobId=" + jobId + ", statusId=" + statusId
				+ "]";
	}
	
	

	

}
