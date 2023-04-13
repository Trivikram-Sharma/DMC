package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.MedicalRecord;

public class MedicalRecordDaoImpl implements MedicalRecordDao{

	@Override
	public boolean addMedicalRecord(MedicalRecord mr) {
		// TODO Auto-generated method stub
		String sql = "insert into medicalrecord(patientId,doctorId,serviceId,serviceName,prescription) values(?,?,?,?,?)";
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				
				psmt.setInt(1, mr.getPatientId());
				psmt.setInt(2, mr.getDoctorId());
				psmt.setInt(3, mr.getServiceId());
				psmt.setString(4, mr.getServiceName());
				psmt.setString(5, mr.getPrescription());
				
				int rows = psmt.executeUpdate();
				
				if(rows > 0 && rows==1) {
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
	public ArrayList<MedicalRecord> getAllMedicalRecords() {
		// TODO Auto-generated method stub
		String sql = "select * from medicalrecord";
		Connection connection = ConnectionHandler.getDbConnection();
		ArrayList<MedicalRecord> mrList = new ArrayList<MedicalRecord>();
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					MedicalRecord mr = new MedicalRecord();
					mr.setRecordId(rs.getInt("recordId"));
					mr.setPatientId(rs.getInt("patientId"));
					mr.setDoctorId(rs.getInt("doctorId"));
					mr.setServiceId(rs.getInt("serviceId"));
					mr.setServiceName(rs.getString("serviceName"));
					mr.setPrescription(rs.getString("prescription"));
					mrList.add(mr);
				}
				
				return mrList;
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
		return mrList;
	}

	@Override
	public MedicalRecord getMedicalRecordById(int mrId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
