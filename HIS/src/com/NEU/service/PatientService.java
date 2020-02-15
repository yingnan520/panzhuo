package com.NEU.service;

import java.util.List;
import java.io.IOException;

import com.NEU.dao.PatientDao;
import com.NEU.model.Patient;

public class PatientService {
	
	private static PatientService singletonInstance = null;
	
	private PatientService() {}
	
	public static PatientService getSingletonInstance() {
		if (singletonInstance == null)
		{
			singletonInstance = new PatientService();
		}
		return singletonInstance;
	}
	
	// 展示病人信息
	
	public List<Patient> showPatientList() throws ClassNotFoundException, IOException {
		
		List<Patient> list = PatientDao.getSingletonInstance().readFromFile();
		
		return list;
		
	}
	
	public List<Patient> writePatientList(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = PatientDao.getSingletonInstance().writeInFile(patient);
		
		return list;
	}
	
	public void writePatientList_2(List<Patient> list) {
		
		PatientDao.getSingletonInstance().writeInFile_2(list);
		
	}
	
}
