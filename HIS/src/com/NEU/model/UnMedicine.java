package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class UnMedicine {             //非药品
	
	public static Map<String , UnMedicine> unmedicineMap = new HashMap<>();
	
	private String unMedicineName;    //非药品名称
	private String unMedicineCode;    //非药品编号
	private String unMedicineSpecification;     //非药品备注
	private String unMedicineFacturer;       //非药品生产厂家
	private float unMedicineFee;      //非药品价格
	
	public UnMedicine(String unMedicineName, String unMedicineCode, String unMedicineSpecification,
			String unMedicineFacturer, float unMedicineFee) {
		super();
		this.unMedicineName = unMedicineName;
		this.unMedicineCode = unMedicineCode;
		this.unMedicineSpecification = unMedicineSpecification;
		this.unMedicineFacturer = unMedicineFacturer;
		this.unMedicineFee = unMedicineFee;
	}

	public String getUnMedicineName() {
		return unMedicineName;
	}

	public void setUnMedicineName(String unMedicineName) {
		this.unMedicineName = unMedicineName;
	}

	public String getUnMedicineCode() {
		return unMedicineCode;
	}

	public void setUnMedicineCode(String unMedicineCode) {
		this.unMedicineCode = unMedicineCode;
	}

	public String getUnMedicineSpecification() {
		return unMedicineSpecification;
	}

	public void setUnMedicineSpecification(String unMedicineSpecification) {
		this.unMedicineSpecification = unMedicineSpecification;
	}

	public String getUnMedicineFacturer() {
		return unMedicineFacturer;
	}

	public void setUnMedicineFacturer(String unMedicineFacturer) {
		this.unMedicineFacturer = unMedicineFacturer;
	}

	public float getUnMedicineFee() {
		return unMedicineFee;
	}

	public void setUnMedicineFee(float unMedicineFee) {
		this.unMedicineFee = unMedicineFee;
	}

	@Override
	public String toString() {
		return "UnMedicine [unMedicineName=" + unMedicineName + ", unMedicineCode=" + unMedicineCode
				+ ", unMedicineSpecification=" + unMedicineSpecification + ", unMedicineFacturer=" + unMedicineFacturer
				+ ", unMedicineFee=" + unMedicineFee + "]";
	}
	
	

}
