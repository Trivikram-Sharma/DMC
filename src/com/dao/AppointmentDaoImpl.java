package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.model.Appointment;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public ArrayList<Appointment> getAppointmentDetailsByPatient(int patientId) {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		String sql = "select * from appointment where patientId=?";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);

				psmt.setInt(1, patientId);

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					Appointment appointment = new Appointment();
					appointment.setAppointmentId(rs.getInt("appointmentId"));
					appointment.setPatientId(rs.getInt("patientId"));
					appointment.setDoctorId(rs.getInt("doctorId"));
					appointment.setTestId(rs.getInt("diagnosticServiceId"));
					appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
					appointment.setRemarks(rs.getString("remarks"));
					if (rs.getDate("appointmentDate") == null) {
						appointment.setAppointmentDate(null);
					} else {
						appointment.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
					}
					if (rs.getTime("appointmentTime") == null) {
						appointment.setAppointmentTime(null);
					} else {
						appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
					}
					appointment.setCriticality(rs.getString("Criticality"));
					appointment.setStatus(rs.getBoolean("status"));

					appointmentList.add(appointment);
				}
				return appointmentList;
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

		return appointmentList;
	}

	@Override
	public ArrayList<Appointment> getAppointmentDetailsByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		String sql = "select * from appointment where doctorId=?";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);

				psmt.setInt(1, doctorId);

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					Appointment appointment = new Appointment();
					appointment.setAppointmentId(rs.getInt("appointmentId"));
					appointment.setPatientId(rs.getInt("patientId"));
					appointment.setDoctorId(rs.getInt("doctorId"));
					appointment.setTestId(rs.getInt("diagnosticServiceId"));
					appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
					appointment.setRemarks(rs.getString("remarks"));
					if (rs.getDate("appointmentDate") == null) {
						appointment.setAppointmentDate(null);
					} else {
						appointment.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
					}
					if (rs.getTime("appointmentTime") == null) {
						appointment.setAppointmentTime(null);
					} else {
						appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
					}
					appointment.setCriticality(rs.getString("Criticality"));
					appointment.setStatus(rs.getBoolean("status"));

					appointmentList.add(appointment);
				}
				return appointmentList;
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

		return appointmentList;
	}

	@Override
	public Appointment getAppointmentDetailsById(int appointmentId) {
		// TODO Auto-generated method stub
		// ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		Appointment appointment = new Appointment();
		String sql = "select * from appointment where appointmentId=?";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);

				psmt.setInt(1, appointmentId);

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {

					appointment.setAppointmentId(rs.getInt("appointmentId"));
					appointment.setPatientId(rs.getInt("patientId"));
					appointment.setDoctorId(rs.getInt("doctorId"));
					appointment.setTestId(rs.getInt("diagnosticServiceId"));
					appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
					appointment.setRemarks(rs.getString("remarks"));
					if (rs.getDate("appointmentDate") == null) {
						appointment.setAppointmentDate(null);
					} else {
						appointment.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
					}
					if (rs.getTime("appointmentTime") == null) {
						appointment.setAppointmentTime(null);
					} else {
						appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
					}
					appointment.setCriticality(rs.getString("Criticality"));
					appointment.setStatus(rs.getBoolean("status"));

				}
				return appointment;
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

		return appointment;
	}

	@Override
	public boolean addAppointmentDetails(Appointment appointment) {
		// TODO Auto-generated method stub
		String sql = "insert into appointment(patientId,doctorId,"
				+ "diagnosticServiceId,diagnosticServiceName,remarks,appointmentDate,appointmentTime,Criticality,status) " + "values(?,?,?,?,?,?,?,?,?)";
		Connection connection = ConnectionHandler.getDbConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement(sql);

			psmt.setInt(1, appointment.getPatientId());
			psmt.setInt(2, appointment.getDoctorId());
			psmt.setInt(3, appointment.getTestId());
			psmt.setString(4, appointment.getDiagnosticServiceName());
			psmt.setString(5, appointment.getRemarks());
			SimpleDateFormat sdf = new SimpleDateFormat("dddd-MM-yy");
			psmt.setDate(6, java.sql.Date.valueOf(sdf.format(appointment.getAppointmentDate())));
			psmt.setTime(7, Time.valueOf(appointment.getAppointmentTime()));
			psmt.setString(8, appointment.getCriticality());
			psmt.setBoolean(9, appointment.isStatus());

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
		return false;
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentDetails() {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		//
		String sql = "select * from appointment";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					Appointment appointment = new Appointment();
					appointment.setAppointmentId(rs.getInt("appointmentId"));
					appointment.setPatientId(rs.getInt("patientId"));
					appointment.setDoctorId(rs.getInt("doctorId"));
					appointment.setTestId(rs.getInt("diagnosticServiceId"));
					appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
					if (rs.getDate("appointmentDate") == null) {
						appointment.setAppointmentDate(null);
					} else {
						appointment.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
					}
					if (rs.getTime("appointmentTime") == null) {
						appointment.setAppointmentTime(null);
					} else {
						appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
					}
					appointment.setCriticality(rs.getString("Criticality"));
					appointment.setStatus(rs.getBoolean("status"));

				}
				return appointmentList;
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
		return appointmentList;
	}

	@Override
	public boolean updateAppointmentDetailsById(Appointment appointment) {
		// TODO Auto-generated method stub
		String sql ="update appointment set appointmentId=?,patientId=?,"
				+ "doctorId=?,diagnosticServiceId=?,DiagnosticServiceName=?,"
				+ "appointmentDate=?,appointmentTime=?,criticality=?,status=?,remarks=?"
				+ "where appointmentId=?";
		Connection connection = ConnectionHandler.getDbConnection();

		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, appointment.getAppointmentId());
			psmt.setInt(2, appointment.getPatientId());
			psmt.setInt(3, appointment.getDoctorId());
			psmt.setInt(4, appointment.getTestId());
			psmt.setString(5, appointment.getDiagnosticServiceName());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dddd-MM-yy");
			psmt.setDate(6, java.sql.Date.valueOf(sdf.format(appointment.getAppointmentDate())));
			psmt.setTime(7, Time.valueOf(appointment.getAppointmentTime()));
			psmt.setString(8, appointment.getCriticality());
			psmt.setBoolean(9, appointment.isStatus());
			psmt.setString(10, appointment.getRemarks());
			psmt.setInt(11, appointment.getAppointmentId());
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
		return false;
	}

}
