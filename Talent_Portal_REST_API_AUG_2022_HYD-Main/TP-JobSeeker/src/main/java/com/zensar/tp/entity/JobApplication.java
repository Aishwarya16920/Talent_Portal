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
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="userName")
    private String userName;
    private int jobId;
////	@Column(name ="userName")
////    private String username;
////    
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name="jobId")
//    private JobEntity job;
    
//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name="statusId")
//    private ApplicationStatusEntity applicationStatus;
    private int  statusId;
    
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
	public JobApplication(int id, String userName, int jobId, int statusId) {
		super();
		this.id = id;
		this.userName = userName;
		this.jobId = jobId;
		this.statusId = statusId;
	}
	public JobApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	}