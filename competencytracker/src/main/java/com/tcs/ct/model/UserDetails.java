package com.tcs.ct.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserDetails")
public class UserDetails {
	
	String userName;
	String password;
	String role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
