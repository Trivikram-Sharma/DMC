package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Test;

public class TestDaoImpl implements TestDao{

	@Override
	public boolean addTestDetails(Test test) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql="insert into test(serviceId,patientId,adminId,testName,result,baseLine) values(?,?,?,?,?,?)";
		
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				
				psmt.setInt(1, test.getServiceId());
				psmt.setInt(2, test.getPatientId());
				psmt.setInt(3, test.getAdminId());
				psmt.setString(4, test.getTestName());
				psmt.setString(5, test.getResult());
				psmt.setString(6, test.getBaseLine());
				
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
	public boolean updateTestDetails(Test test) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getDbConnection();
		String sql="update test set serviceId=?,adminId=?,patientId=?,testName=?,result=?,baseLine=? where"
				+ " testId=?";
		
		if(connection!=null) {
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				
				psmt.setInt(1, test.getServiceId());
				psmt.setInt(2, test.getAdminId());
				psmt.setInt(3, test.getPatientId());
				psmt.setString(4, test.getTestName());
				psmt.setString(5, test.getResult());
				psmt.setString(6, test.getBaseLine());
				psmt.setInt(7, test.getTestId());
				
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
	public Test getTestDetailById(int testId) {
		// TODO Auto-generated method stub
		String sql = "select * from test where testId=?";
		Test test = new Test();
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, testId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				test.setTestId(rs.getInt("testId"));
				test.setServiceId(rs.getInt("serviceId"));
				test.setAdminId(rs.getInt("adminId"));
				test.setPatientId(rs.getInt("patientId"));
				test.setTestName(rs.getString("testName"));
				test.setResult(rs.getString("result"));
				test.setBaseLine(rs.getString("baseLine"));
			}
			return test;
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
		return test;
	}

	@Override
	public ArrayList<Test> getTestDetailsByServiceId(int serviceId) {
		// TODO Auto-generated method stub
		String sql = "select * from test where serviceId=?";
		ArrayList<Test> testList = new ArrayList<Test>();
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, serviceId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Test test = new Test();
				test.setTestId(rs.getInt("testId"));
				test.setServiceId(rs.getInt("serviceId"));
				test.setAdminId(rs.getInt("adminId"));
				test.setPatientId(rs.getInt("patientId"));
				test.setTestName(rs.getString("testName"));
				test.setResult(rs.getString("result"));
				test.setBaseLine(rs.getString("baseLine"));
				testList.add(test);
			}
			return testList;
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
		}}
		return testList;
	}

	@Override
	public ArrayList<Test> getTestDetailsByAdminId(int adminId) {
		// TODO Auto-generated method stub
		String sql = "select * from test where adminId=?";
		ArrayList<Test> testList = new ArrayList<Test>();
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, adminId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Test test = new Test();
				test.setTestId(rs.getInt("testId"));
				test.setServiceId(rs.getInt("serviceId"));
				test.setAdminId(rs.getInt("adminId"));
				test.setPatientId(rs.getInt("patientId"));
				test.setTestName(rs.getString("testName"));
				test.setResult(rs.getString("result"));
				test.setBaseLine(rs.getString("baseLine"));
				testList.add(test);
			}
			return testList;
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
		}}
		return testList;
	}

	@Override
	public ArrayList<Test> getTestDetailsByPatientId(int patientId) {
		// TODO Auto-generated method stub
		String sql = "select * from test where patientId=?";
		ArrayList<Test> testList = new ArrayList<Test>();
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			psmt.setInt(1, patientId);
			
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Test test = new Test();
				test.setTestId(rs.getInt("testId"));
				test.setServiceId(rs.getInt("serviceId"));
				test.setAdminId(rs.getInt("adminId"));
				test.setPatientId(rs.getInt("patientId"));
				test.setTestName(rs.getString("testName"));
				test.setResult(rs.getString("result"));
				test.setBaseLine(rs.getString("baseLine"));
				testList.add(test);
			}
			return testList;
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
		}}
		return testList;
	}

	@Override
	public ArrayList<Test> getAllTestDetails() {
		// TODO Auto-generated method stub
		String sql = "select * from test";
		ArrayList<Test> testList = new ArrayList<Test>();
		Connection connection = ConnectionHandler.getDbConnection();
		if(connection!=null) {
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Test test = new Test();
				test.setTestId(rs.getInt("testId"));
				test.setServiceId(rs.getInt("serviceId"));
				test.setAdminId(rs.getInt("adminId"));
				test.setPatientId(rs.getInt("patientId"));
				test.setTestName(rs.getString("testName"));
				test.setResult(rs.getString("result"));
				test.setBaseLine(rs.getString("baseLine"));
				testList.add(test);
			}
			return testList;
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
		}}
		return testList;
	}
	
}
