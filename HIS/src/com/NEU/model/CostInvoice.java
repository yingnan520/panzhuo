package com.NEU.model;

import java.util.Date;

public class CostInvoice {         //消费发票

	private String invoiceCode;    //发票码
	private Date tDate;        //日期
	private String patientName;    //病人姓名
	private String patientCode;    //病历号
	private String departmentName;    //所在科室名字
	private String departmentCode;    //所在科室编号
	private float medicineFee;     //药品价格
	private float unMedicineFee;    //非药品价格
	private float registrationFee;    //挂号费
	private float totalFee;        //总消费
	
	public CostInvoice(String invoiceCode, Date tDate, String patientName, String patientCode, String departmentName,
			String departmentCode, float medicineFee, float unMedicineFee, float registrationFee, float totalFee) {
		super();
		this.invoiceCode = invoiceCode;
		this.tDate = tDate;
		this.patientName = patientName;
		this.patientCode = patientCode;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.medicineFee = medicineFee;
		this.unMedicineFee = unMedicineFee;
		this.registrationFee = registrationFee;
		this.totalFee = totalFee;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		tDate = new Date();
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public float getMedicineFee() {
		return medicineFee;
	}

	public float getUnMedicineFee() {
		return unMedicineFee;
	}

	public float getRegistrationFee() {
		return registrationFee;
	}

	public float getTotalFee() {
		return totalFee = medicineFee+unMedicineFee+registrationFee;
	}

	@Override
	public String toString() {
		return "CostInvoice [invoiceCode=" + invoiceCode + ", tDate=" + tDate + ", patientName=" + patientName
				+ ", patientCode=" + patientCode + ", departmentName=" + departmentName + ", departmentCode="
				+ departmentCode + ", medicineFee=" + medicineFee + ", unMedicineFee=" + unMedicineFee
				+ ", registrationFee=" + registrationFee + ", totalFee=" + totalFee + "]";
	}
	
	
}
