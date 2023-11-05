package com.zensar.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="tp_application_status")
public class ApplicationStatusEntity {
	
	@Column(name = "status_id")
	@Id
	int statusId;	
	String status;
	public int getStatusId() {
		return statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ApplicationStatusEntity() {
		super();
	}
	public ApplicationStatusEntity(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApplicationStatusEntity [id=" + statusId + ", status=" + status + "]";
	}
	
	

}
