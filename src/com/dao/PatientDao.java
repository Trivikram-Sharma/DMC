package com.dao;

import java.util.ArrayList;

import com.model.Patient;

public interface PatientDao {

	public boolean addPatientDetails(Patient patient);
	
	public Patient findPatientDetailsById(int patientId);
	
	public ArrayList<Patient> findAllPatientDetails();
}
