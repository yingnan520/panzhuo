package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class Doctor {                  //医生
	
	public static Map<String , Doctor> doctorMap = new HashMap<>();
	
	private String doctorName;         //医生名字
	private String doctorCode;         //医生编码
	private boolean doctorGender;      //医生性别
	private int doctorAge;             //医生年龄
	private String account;            //账号
	private String password;           //密码
	private String departmentCode;     //所在科室编码
	private String position;           //职务
	
	public Doctor() {
		
	}
	
	public Doctor(String doctorName, String doctorCode, boolean doctorGender, int doctorAge, String account,
			String password, String departmentCode, String position) {
		super();
		this.doctorName = doctorName;
		this.doctorCode = doctorCode;
		this.doctorGender = doctorGender;
		this.doctorAge = doctorAge;
		this.account = account;
		this.password = password;
		this.departmentCode = departmentCode;
		this.position = position;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public boolean isDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(boolean doctorGender) {
		this.doctorGender = doctorGender;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorCode=" + doctorCode + ", doctorGender=" + ("男".equals(doctorMap.get(doctorCode).isDoctorGender())? "男": "女")
				+ ", doctorAge=" + doctorAge + ", account=" + account + ", password=" + password + ", departmentCode="
				+ departmentCode + ", position=" + position + "]";
	}
	
	
}
