package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.model.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public boolean addDoctorDetails(Doctor doctor) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "insert into doctor(firstName,lastName,dob,Gender,contactNumber,doctorQualifications,address,doctorSpeciality,password)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				//psmt.setInt(1, doctor.getDoctorId());
				psmt.setString(1, doctor.getFirstName());
				psmt.setString(2, doctor.getLastName());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				psmt.setDate(3, java.sql.Date.valueOf(sdf.format(doctor.getDob())));
				psmt.setString(4, doctor.getGender());
				psmt.setLong(5, doctor.getContactNumber());
				psmt.setString(6, doctor.getDoctorQualification());
				psmt.setString(7, doctor.getAddress());
				psmt.setString(8, doctor.getDoctorSpeciality());
				psmt.setString(9, doctor.getPassword());
				//psmt.setDate(10, java.sql.Date.valueOf(sdf.format(doctor.getAppointmentDate())));
				//psmt.setTime(11, Time.valueOf(doctor.getAppointmentTime()));

				int rows = psmt.executeUpdate();
				if (rows > 0 && rows == 1) {
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
	public Doctor findDoctorDetailsById(int doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor = new Doctor();
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "select * from doctor where doctorId=?";
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, doctorId);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					doctor.setDoctorId(rs.getInt("DoctorId"));
					doctor.setFirstName(rs.getString("firstName"));
					doctor.setLastName(rs.getString("lastName"));
					if(rs.getDate("dob")!=null) {
					doctor.setDob(new java.util.Date(rs.getDate("dob").getTime()));}
					else {
						doctor.setDob(null);
					}
					doctor.setGender(rs.getString("Gender"));
					doctor.setContactNumber(rs.getLong("contactNumber"));
					doctor.setDoctorQualification(rs.getString("doctorQualifications"));
					doctor.setAddress(rs.getString("address"));
					doctor.setDoctorSpeciality("doctorSpeciality");
					doctor.setPassword(rs.getString("password"));
					//doctor.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
					//doctor.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
					//doctor.setCriticality(rs.getString("criticality"));

				}
				return doctor;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return doctor;
	}

	@Override
	public ArrayList<Doctor> findAllDoctorDetails() {
		// TODO Auto-generated method stub
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		String sql = "select * from doctor";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Doctor doctor = new Doctor();
					doctor.setDoctorId(rs.getInt("doctorId"));
					doctor.setFirstName(rs.getString("FirstName"));
					doctor.setLastName(rs.getString("LastName"));
					doctor.setDob(new java.util.Date(rs.getDate("dob").getTime()));
					doctor.setGender(rs.getString("Gender"));
					doctor.setContactNumber(rs.getLong("contactNumber"));
					doctor.setDoctorQualification(rs.getString("doctorQualifications"));
					doctor.setAddress(rs.getString("Address"));
					doctor.setDoctorSpeciality(rs.getString("doctorSpeciality"));
					doctor.setPassword(rs.getString("password"));

					doctorList.add(doctor);
				}
				return doctorList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return doctorList;
	}

}
