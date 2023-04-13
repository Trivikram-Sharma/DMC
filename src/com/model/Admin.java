package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Admin {
	
	private int adminId;
	private String password;
	private int testId;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
}
