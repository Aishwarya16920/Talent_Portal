package com.zensar.tp.dto;

import java.util.Objects;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
@Component
public class Employer {
	public Employer(int id, String primarySkill) {
		super();
		this.id = id;
		this.primarySkill = primarySkill;
	}
	@Schema(description="ID")
	private int id;
	@Schema(description="title")
	private String title;
	@Schema(description="description")
	private String description;
	@Schema(description="minExp")
	private int minExp;
	@Schema(description="maxExp")
	private int maxExp;
	@Schema(description="primarySkill")
	private String primarySkill;
	@Schema(description="secSkills")
	private String secSkills;
	@Schema(description="location")
	private String location;
	@Schema(description="status")
	private String status;
	@Schema(description = "userName")
	private String userName;

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, description, location, maxExp, minExp, primarySkill, secSkills, status, title, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(location, other.location) && maxExp == other.maxExp && minExp == other.minExp
				&& Objects.equals(primarySkill, other.primarySkill) && Objects.equals(secSkills, other.secSkills)
				&& Objects.equals(status, other.status) && Objects.equals(title, other.title) && Objects.equals(userName, other.userName);
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

	public Employer() {
		super();
	}
	public Employer(int id, String title, String description, int minExp, int maxExp, String primarySkill,
			String secSkills, String location, String status, String userName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minExp = minExp;
		this.maxExp = maxExp;
		this.primarySkill = primarySkill;
		this.secSkills = secSkills;
		this.location = location;
		this.status = status;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Employer [id=" + id + ", title=" + title + ", description=" + description + ", minExp=" + minExp
				+ ", maxExp=" + maxExp + ", primarySkill=" + primarySkill + ", secSkills=" + secSkills + ", location="
				+ location + ", status=" + status + ", userName=" + userName + "]";
	}
	

	
}
