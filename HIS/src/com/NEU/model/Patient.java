package com.NEU.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Patient implements Serializable{                  //病人
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String patientName;         //病人姓名
	private String patientCode;         //病历号
	private boolean patientGender;      //病人性别
	private int patientAge;             //病人年龄
	private Date birthday;              //病人生日
	private Date registrationDate;      //挂号日期
	private String settlementCode;      //结算类别
	private String idCard;              //身份证号֤
	private String homeAddress;         //家庭住址
	private String registrationCode;    //号别编号
	private String departmentCode;      //科室编号
	private String doctorCode;          //所属医生编号
	private String diseaseType;         //疾病类型
	private boolean isMedicalBook;      //是否要病历本
	private float cost;                 //应收金额
	private int population;             //权重
	private String diagnosisRecod;      //诊断记录
	
	public Patient() {
		
	};
	
	public Patient(String patientCode, String diseaseType) {
		this.patientCode = patientCode;
		this.diseaseType = diseaseType;
	}
	
	public Patient(String patientName, String patientCode, boolean patientGender, int patientAge, Date birthday,
			Date registrationDate, String settlementCode, String idCard, String homeAddress, String registrationCode,
			String departmentCode, String doctorCode, boolean isMedicalBook, float cost) {
		super();
		this.patientName = patientName;
		this.patientCode = patientCode;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.birthday = birthday;
		this.registrationDate = registrationDate;
		this.settlementCode = settlementCode;
		this.idCard = idCard;
		this.homeAddress = homeAddress;
		this.registrationCode = registrationCode;
		this.departmentCode = departmentCode;
		this.doctorCode = doctorCode;
		this.isMedicalBook = isMedicalBook;
		this.cost = cost;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public boolean isPatientGender() {
		return patientGender;
	}

	public void setPatientGender(boolean patientGender) {
		this.patientGender = patientGender;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSettlementCode() {
		return settlementCode;
	}

	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public boolean isMedicalBook() {
		return isMedicalBook;
	}

	public void setMedicalBook(boolean isMedicalBook) {
		this.isMedicalBook = isMedicalBook;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	
	public String getDiagnosisRecod() {
		return diagnosisRecod;
	}

	public void setDiagnosisRecod(String diagnosisRecod) {
		this.diagnosisRecod = diagnosisRecod;
	}

	@Override
	public String toString() {
		return "Patient [patientCode=" + patientCode + ", diseaseType=" + diseaseType + "]";
	}



	public static Comparator<Patient> OrderIsdn = new Comparator<Patient>() {

		@Override
		public int compare(Patient o1, Patient o2) {
			int numberA = o1.getPopulation();
			int numberB = o2.getPopulation();
			if (numberB > numberA) {
				return 1;
			}else if (numberB < numberA) {
				return -1;
			}else {
				return 0;
			}
		}
		
	};
	
	/*
	 * @Override public String toString() { return "Patient [patientName=" +
	 * patientName + ", patientCode=" + patientCode + ", patientGender=" +
	 * ("男".equals(patientMap.get(patientCode).isPatientGender())? "男": "女") +
	 * ", patientAge=" + patientAge + ", birthday=" + birthday + ", settlementCode="
	 * + settlementCode + ", idCard=" + idCard + ", homeAddress=" + homeAddress +
	 * ", registrationCode=" + registrationCode + ", departmentCode=" +
	 * departmentCode + ", doctorCode=" + doctorCode + ", isMedicalBook=" +
	 * ("是".equals(patientMap.get(patientCode).isMedicalBook)? "是": "否") + ", cost="
	 * + cost + "]"; }
	 */
    
    
}
