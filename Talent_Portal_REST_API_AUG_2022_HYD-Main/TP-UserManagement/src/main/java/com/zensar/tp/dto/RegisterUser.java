package com.zensar.tp.dto;

import com.zensar.tp.dto.RegisterUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="info")
public class RegisterUser { 
	@ApiModelProperty(value="user ID")
	private int id;
	@ApiModelProperty(value="user first name")
	private String firstName;
	@ApiModelProperty(value="user last name")
	private String lastName;
	@ApiModelProperty(value="user name")
	private String username;
	@ApiModelProperty(value="user password")
	private String password;
	@ApiModelProperty(value="user email")
	private String email;
	@ApiModelProperty(value="user phoneno.")
	private String phone;
	public String role=null;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String firstName, String lastName, String username, String password, String email,
				String phone) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.email = email;
			this.phone = phone;
	}
	public RegisterUser(int id,String firstName, String lastName, String username, String password, String email,
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
		this.id=id;
	}
	public void setRole(String role) {
		if(role==null||role.equals("ROLE_USER")) {
			this.role = "ROLE_USER";
			}
			else {
				this.role="ROLE_ADMIN";
			}
			
		}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getRole() {
		return role;
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
	  public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegisterUser other = (RegisterUser) obj;
        return id == other.id;
    }


}