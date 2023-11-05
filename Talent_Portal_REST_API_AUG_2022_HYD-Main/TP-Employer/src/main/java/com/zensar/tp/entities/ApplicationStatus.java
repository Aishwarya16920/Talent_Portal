package com.zensar.tp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tp_application_status")
public class ApplicationStatus {
	@Column(name = "status_id")
	@Id
	int statusId;	
	String status;
	public int getId() {
		return statusId;
	}
	public String getStatus() {
		return status;
	}
	public ApplicationStatus() {
		super();
	}
	public ApplicationStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApplicationstatusEntity [id=" + statusId + ", status=" + status + "]";
	}
}
