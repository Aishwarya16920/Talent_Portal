package com.zensar.tp.entities;



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
    private int jobId;
    
 
    public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
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

	public JobApplicationEntity(int id, String userName, JobEntity job) {
		super();
		this.id = id;
		this.userName = userName;
	}
	public JobApplicationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}