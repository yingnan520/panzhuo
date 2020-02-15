package com.NEU.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.NEU.model.Patient;
import com.NEU.tool.Read;
import com.NEU.tool.Write;

public class PatientDao {
	
	private static PatientDao singletonInstance = null;
	
	private PatientDao() {}
	
	public static PatientDao getSingletonInstance() {
		if (singletonInstance == null)
		{
			singletonInstance = new PatientDao();
		}
		return singletonInstance;
	}
	
	// 从文件中得到病人信息
	
	public List<Patient> readFromFile() throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>(); 
		
		list = Read.read("patient.txt");
		
		return list;
		
	}
	
	public List<Patient> writeInFile(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>();
		
		// TODO 保存到文件
		list = Read.read("patient.txt");
		// TODO 获取列表
		list.add(patient);
		
		Write.write(list, "patient.txt");
		
		return list;
	}
	
	public void writeInFile_2(List<Patient> list) {
		
		try {
			Write.write(list, "patient.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
