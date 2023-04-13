package com.dao;

import java.util.ArrayList;

import com.model.Doctor;

public interface DoctorDao {
	
	public boolean addDoctorDetails(Doctor doctor);
	
	public Doctor findDoctorDetailsById(int doctorId);
	
	public ArrayList<Doctor> findAllDoctorDetails();
	
}
