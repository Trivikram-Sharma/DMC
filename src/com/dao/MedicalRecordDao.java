package com.dao;

import java.util.ArrayList;

import com.model.MedicalRecord;

public interface MedicalRecordDao {
	public boolean addMedicalRecord(MedicalRecord mr);
	
	public ArrayList<MedicalRecord> getAllMedicalRecords();
	
	public MedicalRecord getMedicalRecordById(int mrId);
}
