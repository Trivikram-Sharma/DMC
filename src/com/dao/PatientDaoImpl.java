package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.model.Patient;

public class PatientDaoImpl implements PatientDao {

	@Override
	public boolean addPatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "insert into patient(FirstName,LastName,dob,Gender,contactNumber,Address,Password)"
				+ " values(?,?,?,?,?,?,?)";
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				//psmt.setInt(1, patient.getPatientId());
				psmt.setString(1, patient.getFirstName());
				psmt.setString(2, patient.getLastName());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				psmt.setDate(3, Date.valueOf(sdf.format(patient.getDob())));
				psmt.setString(4, patient.getGender());
				psmt.setLong(5, patient.getContactNumber());
				psmt.setString(6, patient.getAddress());
				psmt.setString(7, patient.getPassword());
				/*psmt.setDate(8, Date.valueOf(sdf.format(patient.getAppointmentDate())));
				if(patient.getAppointmentTime()!=null) {
				psmt.setTime(9, Time.valueOf(patient.getAppointmentTime()));}
				else {
					psmt.setTime(9, null);
				}
				psmt.setInt(10, patient.getTestId());
				psmt.setString(11, patient.getMessage());
				*/
				int rows = psmt.executeUpdate();
				if(rows>0 && rows==1) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public Patient findPatientDetailsById(int patientId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "select * from patient where patientId=?";
		Patient patient = new Patient();
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, patientId);
				
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					patient.setPatientId(rs.getInt("patientId"));
					patient.setFirstName(rs.getString("FirstName"));
					patient.setLastName(rs.getString("LastName"));
					if(rs.getDate("dob")!=null) {
					patient.setDob(new java.util.Date(rs.getDate("dob").getTime()));}
					else {
						patient.setDob(null);
					}
					patient.setGender(rs.getString("Gender"));
					patient.setContactNumber(rs.getLong("contactNumber"));
					patient.setAddress(rs.getString("Address"));
					patient.setPassword(rs.getString("Password"));
				}
				return patient;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return patient;
	}

	@Override
	public ArrayList<Patient> findAllPatientDetails() {
		// TODO Auto-generated method stub
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "select * from patient";
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					Patient patient = new Patient();
					patient.setPatientId(rs.getInt("patientId"));
					patient.setFirstName(rs.getString("FirstName"));
					patient.setLastName(rs.getString("LastName"));
					if(rs.getDate("dob")!=null) {
					patient.setDob(new java.util.Date(rs.getDate("dob").getTime()));}
					else {
						patient.setDob(null);
					}
					patient.setGender(rs.getString("Gender"));
					patient.setContactNumber(rs.getLong("contactNumber"));
					patient.setAddress(rs.getString("Address"));
					patient.setPassword(rs.getString("Password"));
					
					patientList.add(patient);
				}
				return patientList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return patientList;
	}

}
