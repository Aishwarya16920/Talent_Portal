package com.zensar.tp.dto;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
@Component
public class JobsApplied {
	@Schema(description="id")
	private int id;
	@Schema(description="skill")
	private String skill;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public JobsApplied() {
		super();
	}
	public JobsApplied(int id, String skill) {
		super();
		this.id = id;
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return "JobsApplied [id=" + id + ", skill=" + skill + "]";
	}
	

	

}
