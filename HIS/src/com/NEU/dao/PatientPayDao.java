package com.NEU.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.NEU.model.Patient;
import com.NEU.tool.Read;
import com.NEU.tool.Write;

public class PatientPayDao {
	
	private static PatientPayDao singletonInstance = null;
	
	private PatientPayDao() {}
	
	public static PatientPayDao getSingletonInstance() {
		if (singletonInstance == null)
		{
			singletonInstance = new PatientPayDao();
		}
		return singletonInstance;
	}
	
	// 从文件中得到病人信息
	
	public List<Patient> readFromFile() throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>(); 
		
		list = Read.read("patientpay.txt");
		
		return list;
		
	}
	
	public List<Patient> writeInFile(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>();
		
		// TODO 保存到文件
		list = Read.read("patientpay.txt");
		// TODO 获取列表
		list.add(patient);
		
		Write.write(list, "patientpay.txt");
		
		return list;
	}
	
	public void writeInFile_2(List<Patient> list) {
		
		try {
			Write.write(list, "patientpay.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
