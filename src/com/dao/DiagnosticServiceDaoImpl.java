package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.DiagnosticService;

public class DiagnosticServiceDaoImpl implements DiagnosticServiceDao{

	@Override
	public DiagnosticService getDiagnosticServiceById(int diagnosticServiceId) {
		// TODO Auto-generated method stub
		DiagnosticService ds = new DiagnosticService();
		String sql="select * from diagnosticservice where DiagnosticServiceId=?";
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, diagnosticServiceId);
				
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					ds.setDiagnosticServiceId(rs.getInt("DiagnosticServiceId"));
					ds.setDiagnosticServiceName(rs.getString("DiagnosticServiceName"));
					ds.setBriefOnDiagnosticCenter(rs.getString("briefOnDiagnosticCenter"));
					ds.setFacilitiesAvailable(rs.getString("facilitiesAvailable"));
					ds.setSpeciality(rs.getString("speciality"));
					ds.setAddress(rs.getString("Address"));
					
				}
				return ds;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return ds;
	}

	@Override
	public boolean addDiagnosticService(DiagnosticService ds) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "insert into "
				+ "diagnosticservice(DiagnosticServiceName,briefOnDiagnosticCenter,"
				+ "facilitiesAvailable,speciality,Address) values(?,?,?,?,?)";
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setString(1, ds.getDiagnosticServiceName());
				psmt.setString(2, ds.getBriefOnDiagnosticCenter());
				psmt.setString(3, ds.getFacilitiesAvailable());
				psmt.setString(4, ds.getSpeciality());
				psmt.setString(5, ds.getAddress());
				
				int rows = psmt.executeUpdate();
				
				if(rows>0 && rows==1) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
	public ArrayList<DiagnosticService> getAllDiagnosticServices() {
		// TODO Auto-generated method stub
		String sql = "select * from diagnosticservice";
		Connection connection = ConnectionHandler.getDbConnection();
		ArrayList<DiagnosticService> dsList = new ArrayList<DiagnosticService>();
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);

				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					DiagnosticService ds = new DiagnosticService();
					ds.setDiagnosticServiceId(rs.getInt("DiagnosticServiceId"));
					ds.setDiagnosticServiceName(rs.getString("DiagnosticServiceName"));
					ds.setBriefOnDiagnosticCenter(rs.getString("briefOnDiagnosticCenter"));
					ds.setFacilitiesAvailable(rs.getString("facilitiesAvailable"));
					ds.setSpeciality(rs.getString("speciality"));
					ds.setAddress(rs.getString("Address"));
					dsList.add(ds);
				}
				return dsList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return dsList;
	}

}
