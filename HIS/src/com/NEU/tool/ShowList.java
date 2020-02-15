package com.NEU.tool;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.NEU.model.Medicine;
import com.NEU.model.Patient;

public class ShowList {
	
	public static void showList(List<Patient> patientList,DefaultTableModel model) {
		
		for (int i = 0;i < patientList.size();i ++) {
			Patient p = patientList.get(i);
			model.addRow(new Object[] {p.getPatientCode(),p.getPatientName(),p.getPatientAge(),p.getBirthday(),p.isPatientGender()
					,p.getIdCard(),p.getRegistrationCode(),p.getSettlementCode(),p.getRegistrationCode(),p.getRegistrationDate()
					,p.isMedicalBook(),p.getCost(),p.getDepartmentCode(),p.getDoctorCode()});
		}
	}
	
	public static void showMedicineList(List<Medicine> medicineList,DefaultTableModel model) {
		
		for (int i = 0;i < medicineList.size();i ++) {
			Medicine m = medicineList.get(i);
			model.addRow(new Object[] {m.getMedicineCode(),m.getMedicineName(),m.getMedicineFee(),
					m.getMedicineSpecification(),m.getNumber()});
		}
	}

}
