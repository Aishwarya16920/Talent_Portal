package com.zensar.tp.dto;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;

@Component
public class Applicationstatus {
	
	@Schema(description="statusId")
	int statusId;
	@Schema(description="status")
	String status;
	
	@Override
	public String toString() {
		return "Applicationstatus [statusId=" + statusId + ", status=" + status + "]";
	}

	public Applicationstatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	

	
	public Applicationstatus() {
		super();
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	
	

}
