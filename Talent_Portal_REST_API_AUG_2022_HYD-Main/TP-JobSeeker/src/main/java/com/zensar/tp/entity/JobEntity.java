package com.zensar.tp.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tp_job")
public class JobEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	private String description;
	private int minExp;
	private int maxExp;
	private String primarySkill;
	private String secSkills;
	private String location;
	private String status;
	private int statusId;
	private String username;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate = new Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	
	public JobEntity(int id, String primarySkill) {
		super();
		this.id = id;
		this.primarySkill = primarySkill;
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

	public JobEntity() {
		super();
	}

	public JobEntity(String title, String description, int minExp, int maxExp, String primarySkill,
			String secSkills, String location, String status) {
		super();
		this.title = title;
		this.description = description;
		this.minExp = minExp;
		this.maxExp = maxExp;
		this.primarySkill = primarySkill;
		this.secSkills = secSkills;
		this.location = location;
		this.status = status;
//		this.isApplied=isApplied;
	}
	
	
	public JobEntity(String title, String description, int minExp, int maxExp, String primarySkill,
			String secSkills, String location, boolean isApplied, Date createdDate) {
		super();
//		this.id = id;
		this.title = title;
		this.description = description;
		this.minExp = minExp;
		this.maxExp = maxExp;
		this.primarySkill = primarySkill;
		this.secSkills = secSkills;
		this.location = location;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getMinExp() {
		return minExp;
	}
	
	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}
	
	public int getMaxExp() {
		return maxExp;
	}
	
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}
	
	public String getPrimarySkill() {
		return primarySkill;
	}
	
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	
	public String getSecSkills() {
		return secSkills;
	}
	
	public void setSecSkills(String secSkills) {
		this.secSkills = secSkills;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", title=" + title + ", description=" + description + ", minExp=" + minExp
				+ ", maxExp=" + maxExp + ", primarySkill=" + primarySkill + ", secSkills=" + secSkills + ", location="
				+ location + ", status=" + status + "]";
	}
	
	
	
	
}
