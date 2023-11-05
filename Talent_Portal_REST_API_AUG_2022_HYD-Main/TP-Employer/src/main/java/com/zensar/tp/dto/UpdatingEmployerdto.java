package com.zensar.tp.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
@Component
public class UpdatingEmployerdto {
	@Schema(description="Id")
	private int id;
	@Schema(description="Title")
	private String title;
	@Schema(description="Description")
	private String description;
	@Schema(description="MinExp")
	private int minExp;
	@Schema(description="MinExp")
	private int maxExp;
	@Schema(description="PrimarySkill")
	private String primarySkill;
	@Schema(description="SecSkills")
	private String secSkills;
	@Schema(description="Location")
	private String location;
	@Schema(description="status")
	private String status;
	@Temporal(TemporalType.DATE)
	private Date modifiedDate=new Date(System.currentTimeMillis());;
	
	public UpdatingEmployerdto(String title, String description, int minExp, int maxExp, String primarySkill,
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
	}
	public UpdatingEmployerdto() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, location, maxExp, minExp, modifiedDate, primarySkill, secSkills, status,
				title, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdatingEmployerdto other = (UpdatingEmployerdto) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(location, other.location) && maxExp == other.maxExp && minExp == other.minExp
				&& Objects.equals(modifiedDate, other.modifiedDate) && Objects.equals(primarySkill, other.primarySkill)
				&& Objects.equals(secSkills, other.secSkills) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title) && Objects.equals(userName, other.userName);
	}
	private String userName ;
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
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
