package com.zensar.tp.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserDetails {
	@Id
	@Column(name="ID")
    private int id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "mobilenumber")
	private String phone;
	@Column(name = "role")
	public String role;
	public UserDetails() {
		super();
	}
	
	public UserDetails(String firstName, String lastName, String username, String password, String email,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public UserDetails(int id, String firstName, String lastName, String username, String password, String email,
			String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "RegisterUserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
}
