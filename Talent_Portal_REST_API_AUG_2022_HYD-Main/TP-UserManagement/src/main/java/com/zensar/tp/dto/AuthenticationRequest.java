package com.zensar.tp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User model holdes username, password and role of the user or admin")
public class AuthenticationRequest {
public AuthenticationRequest(String username, String password,String role) {
	this.username=username;
	this.password=password;
	this.role=role;
		
	}
@ApiModelProperty(value="Username of the user or admin")
	private String username;
@ApiModelProperty(value="Password of the user and password")
private String password;
@ApiModelProperty(value="Role of the user and admin")
private String role;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
