package com.dao;

import java.util.ArrayList;

import com.model.Admin;

public interface AdminDao {
	public boolean addAdminDetails(Admin admin);

	public Admin findAdminById(int adminId);
	
	public ArrayList<Admin> findAllAdminDetails();
	
}
