package com.NEU.model;

public class Medicine {              //药品
	
	private String medicineName;    //药品名称
	private String medicineCode;    //药品编号
	private String medicineSpecification;     //药品备注
	private String departmentCode;  //所在科室编号
	private String medicineFacturer;       //生产厂家
	private int number;          //库存
	private float medicineFee;      //药品价格
	
	public Medicine() {};
	
	public Medicine(String medicineName, String medicineCode, String medicineSpecification, String departmentCode, String medicineFacturer,
			float medicineFee) {
		super();
		this.medicineName = medicineName;
		this.medicineCode = medicineCode;
		this.medicineSpecification = medicineSpecification;
		this.departmentCode = departmentCode;
		this.medicineFacturer = medicineFacturer;
		this.medicineFee = medicineFee;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getMedicineSpecification() {
		return medicineSpecification;
	}

	public void setMedicineSpecification(String medicineSpecification) {
		this.medicineSpecification = medicineSpecification;
	}

	public String getMedicineFacturer() {
		return medicineFacturer;
	}

	public void setMedicineFacturer(String medicineFacturer) {
		this.medicineFacturer = medicineFacturer;
	}

	public float getMedicineFee() {
		return medicineFee;
	}

	public void setMedicineFee(float medicineFee) {
		this.medicineFee = medicineFee;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Medicine [medicineName=" + medicineName + ", medicineCode=" + medicineCode + ", number="
				+ number + ", medicineFee=" + medicineFee + "]";
	}


}
