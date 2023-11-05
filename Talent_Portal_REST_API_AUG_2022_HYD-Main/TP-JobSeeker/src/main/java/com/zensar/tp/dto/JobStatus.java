package com.zensar.tp.dto;

public class JobStatus {
	private int id;
	private int jobId;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	private String userName;
	public JobStatus(int id, int jobId, String userName, String status, String title, String location) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.userName = userName;
		this.status = status;
		this.title = title;
		this.location = location;
	}
	private String status;
	private String title;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public JobStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobStatus(int id, String userName, String status, String title, String location) {
		super();
		this.id = id;
		this.userName = userName;
		this.status = status;
		this.title = title;
		this.location = location;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
