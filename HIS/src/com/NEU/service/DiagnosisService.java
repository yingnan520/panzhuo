package com.NEU.service;

import java.io.IOException;
import java.util.List;

import com.NEU.dao.DiagnosisDao;
import com.NEU.model.Patient;

public class DiagnosisService {
	
	private static DiagnosisService singletonInstance = null;
	
	private DiagnosisService() {}
	
	public static DiagnosisService getSingletonInstance() {
		
		if (singletonInstance == null)
		{
			singletonInstance = new DiagnosisService();
		}
		return singletonInstance;
	}
	
	// 展示病人信息
	
	public List<Patient> showPatientList() throws ClassNotFoundException, IOException {
		
		List<Patient> list = DiagnosisDao.getSingletonInstance().readFromFile();
		
		return list;
		
	}
	
	public List<Patient> writePatientList(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = DiagnosisDao.getSingletonInstance().writeInFile(patient);
		
		return list;
	}
	
	public void writePatientList_2(List<Patient> list) {
		
		DiagnosisDao.getSingletonInstance().writeInFile_2(list);
		
	}

}
