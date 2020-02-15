package com.NEU.model;

import java.util.Date;

public class RegistrationInvoice {     //挂号发票
	
	private String invoiceCode;    //发票码
	private Date tDate;        //日期
	private String patientName;    //病人姓名
	private String patientCode;    //病历号
	private String departmentName;    //所在科室名字
	private String departmentCode;    //所在科室编号
	private String registrationName;   //号别名称
	private String registrationCode;   //号别编号
	private boolean isDefault;         //是否默认
	private String orderCode;          //顺序号
	private float registrationFee;     //挂号费
	
	public RegistrationInvoice(String invoiceCode, Date tDate, String patientName, String patientCode,
			String departmentName, String departmentCode, String registrationName, String registrationCode,
			boolean isDefault, String orderCode, float registrationFee) {
		super();
		this.invoiceCode = invoiceCode;
		this.tDate = tDate;
		this.patientName = patientName;
		this.patientCode = patientCode;
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
		this.registrationName = registrationName;
		this.registrationCode = registrationCode;
		this.isDefault = isDefault;
		this.orderCode = orderCode;
		this.registrationFee = registrationFee;
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

	public String getRegistrationName() {
		return registrationName;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public boolean isDefault() {
		return isDefault;
	}
	
	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public float getRegistrationFee() {
		return registrationFee;
	}

	@Override
	public String toString() {
		return "RegistrationInvoice [invoiceCode=" + invoiceCode + ", tDate=" + tDate + ", patientName=" + patientName
				+ ", patientCode=" + patientCode + ", departmentName=" + departmentName + ", departmentCode="
				+ departmentCode + ", registrationName=" + registrationName + ", registrationCode=" + registrationCode
				+ ", isDefault=" + ("是".equals(Registration.registrationMap.get(registrationCode).isDefault())? "是": "否") + ", orderCode=" + orderCode + ", registrationFee=" + registrationFee
				+ "]";
	}
	
	
}