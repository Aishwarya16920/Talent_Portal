package com.zensar.tp.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="job_application")
public class JobApplicationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="userName")
    private String userName;
//    private int jobId;
//	@Column(name ="userName")
//    private String username;
//    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="jobId")
    private JobEntity job;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="statusId")
    private ApplicationStatusEntity applicationStatus;
    
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public JobEntity getJob() {
		return job;
	}
	public void setJob(JobEntity job) {
		this.job = job;
	}
	
	
	public ApplicationStatusEntity getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(ApplicationStatusEntity applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "JobApplicationEntity [id=" + id + ", userName=" + userName + ", job=" + job + ", applicationStatus="
				+ applicationStatus + "]";
	}
	public JobApplicationEntity(int id, String userName, JobEntity job, ApplicationStatusEntity applicationStatus) {
		super();
		this.id = id;
		this.userName = userName;
		this.job = job;
		this.applicationStatus = applicationStatus;
	}
	public JobApplicationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
	


    
    



}