package com.dao;

import java.util.ArrayList;

import com.model.DiagnosticService;

public interface DiagnosticServiceDao {

	public DiagnosticService getDiagnosticServiceById(int id);

	public boolean addDiagnosticService(DiagnosticService ds);
	
	public ArrayList<DiagnosticService> getAllDiagnosticServices();
}
