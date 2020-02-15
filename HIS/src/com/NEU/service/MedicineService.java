package com.NEU.service;

import java.io.IOException;
import java.util.List;

import com.NEU.dao.MedicineDao;
import com.NEU.model.Medicine;

public class MedicineService {

	private static MedicineService singletonInstance = null;
	
	private MedicineService() {}
	
	public static MedicineService getSingletonInstance() {
		if (singletonInstance == null)
		{
			singletonInstance = new MedicineService();
		}
		return singletonInstance;
	}
	
	public List<Medicine> showMedicineList() throws ClassNotFoundException, IOException {
		
		List<Medicine> list = MedicineDao.getSingletonInstance().readFromFile();
		
		return list;
		
	}
	
}
