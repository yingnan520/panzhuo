package com.NEU.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.NEU.model.Patient;
import com.NEU.tool.Read;
import com.NEU.tool.Write;

public class DiagnosisDao {
	
	private static DiagnosisDao singletonInstance = null;
	
	private DiagnosisDao() {}
	
	public static DiagnosisDao getSingletonInstance() {
		
		if (singletonInstance == null)
		{
			singletonInstance = new DiagnosisDao();
		}
		return singletonInstance;
	}
	
	public List<Patient> readFromFile() throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>(); 
		
		list = Read.read("disgnosispatient.txt");
		
		return list;
		
	}
	
	public List<Patient> writeInFile(Patient patient) throws ClassNotFoundException, IOException {
		
		List<Patient> list = new ArrayList<Patient>();
		
		// TODO 保存到文件
		list = Read.read("disgnosispatient.txt");
		// TODO 获取列表
		list.add(patient);
		
		Write.write(list, "disgnosispatient.txt");
		
		return list;
	}
	
	public void writeInFile_2(List<Patient> list) {
		
		try {
			Write.write(list, "disgnosispatient.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
