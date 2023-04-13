package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean addAdminDetails(Admin admin) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			String sql = "insert into admin(Password) values(?)";
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				//psmt.setInt(1, admin.getAdminId());
				psmt.setString(1, admin.getPassword());

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
	public Admin findAdminById(int adminId) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		String sql = "select * from admin where AdminId=?";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setInt(1, adminId);

				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					admin.setAdminId(rs.getInt("AdminId"));
					admin.setPassword(rs.getString("Password"));
					admin.setTestId(rs.getInt("testId"));
				}
				return admin;
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
		return admin;
	}

	@Override
	public ArrayList<Admin> findAllAdminDetails() {
		// TODO Auto-generated method stub
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		String sql = "select * from admin";
		Connection connection = ConnectionHandler.getDbConnection();
		if (connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Admin admin = new Admin();
					admin.setAdminId(rs.getInt("AdminId"));
					admin.setPassword(rs.getString("Password"));
					admin.setTestId(rs.getInt("testId"));
					adminList.add(admin);
				}
				return adminList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return adminList;
	}

}
