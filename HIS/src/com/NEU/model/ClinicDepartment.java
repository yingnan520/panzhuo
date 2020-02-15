package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class ClinicDepartment extends Department {    //临床科室
	
	public static Map<String , ClinicDepartment> clinicdepartmentMap = new HashMap<>();
	
	private String patientCode;      //病历号
	private String doctorCode;       //医生编号
	private String medicineCode;     //药品编号
	
	public ClinicDepartment(String departmentName, String departmentCode, String patientCode, String doctorCode, String medicineCode) {
		super(departmentName, departmentCode);
		this.patientCode = patientCode;
		this.doctorCode = doctorCode;
		this.medicineCode = medicineCode;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentCode() {
		return departmentCode;
	}
	
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "ClinicDepartment [patientCode=" + patientCode + ", doctorCode=" + doctorCode + ", medicineCode="
				+ medicineCode + ", departmentName=" + departmentName + ", departmentCode=" + departmentCode + "]";
	}

}
