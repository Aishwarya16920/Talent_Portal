package com.zensar.tp.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;

@Component
public class Job {
	
	@Schema(description="Id")
	private int id;
	
	@Schema(description="PrimarySkill")
	private String primarySkill;
	
	@Schema(description="SecondarySkill")
	private String secSkill;
	
	@Schema(description="location")
	private String location;
	
	@Schema(description="title")
	private String title;
	
	@Schema(description="minExp")
	private int minExp;
	
	@Schema(description="maxExp")
	private int maxExp;
	
	@Schema(description="description")
private String description;
	@Schema(description="createdDate")
private Date createdDate;
	
	private boolean isApplied;
	


	
public String getSecSkill() {
		return secSkill;
	}
	public void setSecSkill(String secSkill) {
		this.secSkill = secSkill;
	}
public int getMaxExp() {
		return maxExp;
	}
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPrimarySkill() {
	return primarySkill;
}
public void setPrimarySkill(String primaySkill) {
	this.primarySkill = primaySkill;
}

public int getMinExp() {
	return minExp;
}
public void setMinExp(int minExp) {
	this.minExp = minExp;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}


public boolean getIsApplied() {
	return isApplied;
}
public void setIsApplied(boolean isApplied) {
	this.isApplied = isApplied;
}


public Job(int id, String primarySkill, String secSkill, String location, String title, int minExp, int maxExp,
		String description, Date createdDate, boolean isApplied) {
	super();
	this.id = id;
	this.primarySkill = primarySkill;
	this.secSkill = secSkill;
	this.location = location;
	this.title = title;
	this.minExp = minExp;
	this.maxExp = maxExp;
	this.description = description;
	this.createdDate = createdDate;
	this.isApplied = isApplied;
}

public Job(int id, String primarySkill, String secSkill, String location, String title, int minExp, int maxExp,
		String description, Date createdDate) {
	super();
	this.id = id;
	this.primarySkill = primarySkill;
	this.secSkill = secSkill;
	this.location = location;
	this.title = title;
	this.minExp = minExp;
	this.maxExp = maxExp;
	this.description = description;
	this.createdDate = createdDate;
}



@Override
public String toString() {
	return "Job [id=" + id + ", primarySkill=" + primarySkill + ", secSkill=" + secSkill + ", location=" + location
			+ ", title=" + title + ", minExp=" + minExp + ", maxExp=" + maxExp + ", description=" + description
			+ ", createdDate=" + createdDate + ", isApplied=" + isApplied + "]";
}
public Job() {
	super();
}


}
