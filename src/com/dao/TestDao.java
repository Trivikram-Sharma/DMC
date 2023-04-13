package com.dao;

import java.util.ArrayList;

import com.model.Test;

public interface TestDao {
	
	public boolean addTestDetails(Test test);
	
	public boolean updateTestDetails(Test test);
	
	public Test getTestDetailById(int testId);
	
	public ArrayList<Test> getTestDetailsByServiceId(int serviceId);
	
	public ArrayList<Test> getTestDetailsByAdminId(int adminId);
	
	public ArrayList<Test> getTestDetailsByPatientId(int patientId);
	
	public ArrayList<Test> getAllTestDetails();
}
