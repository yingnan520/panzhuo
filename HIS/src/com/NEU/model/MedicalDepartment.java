package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class MedicalDepartment extends Department {        //医技科室
	
	public static Map<String , MedicalDepartment> medicaldepartmentMap = new HashMap<>();
	
	private String doctorCode;       //医生编号

	public MedicalDepartment(String departmentName, String departmentCode, String doctorCode) {
		super(departmentName, departmentCode);
		this.doctorCode = doctorCode;
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
		return "MedicalDepartment [doctorCode=" + doctorCode + ", departmentName=" + departmentName
				+ ", departmentCode=" + departmentCode + "]";
	}

	

}
