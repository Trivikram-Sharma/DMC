package com.dao;

import java.util.ArrayList;

import com.model.Appointment;

public interface AppointmentDao {
	
	public ArrayList<Appointment> getAppointmentDetailsByPatient(int patientId);
	
	public ArrayList<Appointment> getAppointmentDetailsByDoctorId(int doctorId);
	
	public Appointment getAppointmentDetailsById(int appointmentId);
	
	public boolean addAppointmentDetails(Appointment appointment);
	
	public boolean updateAppointmentDetailsById(Appointment appointment);
	
	public ArrayList<Appointment> getAllAppointmentDetails();
	
}
