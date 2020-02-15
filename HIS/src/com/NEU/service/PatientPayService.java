package com.NEU.service;

import java.io.IOException;
import java.util.List;
import com.NEU.dao.PatientPayDao;
import com.NEU.model.Patient;

public class PatientPayService {
	
	private static PatientPayService singletonInstance = null;
	
	private PatientPayService() {}
	
	public static PatientPayService getSingletonInstance() {
		if (singletonInstance == null)
		{
			singletonInstance = new PatientPayService();
		}
		return singletonInstance;
	}
	
	// 展示病人信息
	
	public List<Patient> showPatientList() throws ClassNotFoundException, IOException {
		
		List<Patient> list = PatientPayDao.getSingletonInstance().readFromFile();
		
		return list;
		
	}
	
	public List<Patient> writePatientList(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = PatientPayDao.getSingletonInstance().writeInFile(patient);
		
		return list;
	}
	
	public void writePatientList_2(List<Patient> list) {
		
		PatientPayDao.getSingletonInstance().writeInFile_2(list);
		
	}

}
