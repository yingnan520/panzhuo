package com.NEU.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.NEU.model.Medicine;
import com.NEU.tool.ReadMedicine;

public class MedicineDao {
	
	private static MedicineDao singletonInstance = null;
	
	private MedicineDao() {}
	
	public static MedicineDao getSingletonInstance() {
		
		if (singletonInstance == null)
		{
			singletonInstance = new MedicineDao();
		}
		return singletonInstance;
	}
	
	public List<Medicine> readFromFile() throws ClassNotFoundException, IOException {
		
		List<String> list = ReadMedicine.readFile("medicine.txt");
		List<Medicine> mList = new ArrayList<Medicine>();
		
		for (int i = 0;i < list.size();i ++) {
			Medicine m = new Medicine();
			String[] s = list.get(i).split("，");
			m.setMedicineCode(s[0]);
			m.setMedicineName(s[1]);
			float f = Float.parseFloat(s[2]);
			m.setMedicineFee(f);
			m.setMedicineSpecification(s[3]);
			int n = Integer.parseInt(s[4]);
			m.setNumber(n);
			mList.add(m);
		}
		
		return mList;
		
	}

}
