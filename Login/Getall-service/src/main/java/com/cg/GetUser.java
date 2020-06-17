package com.cg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class GetUser {
	
	private int employeeId;
	
	private String userName;
	
	private String password;
	
	private String role;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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

	public GetUser(int employeeId, String userName, String password, String role) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public GetUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GetUser [employeeId=" + employeeId + ", userName=" + userName + ", password=" + password + ", role="
				+ role + "]";
	}
		
	
}


