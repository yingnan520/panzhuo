package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class Registration {            //号别
	
	public static Map<String , Registration> registrationMap = new HashMap<>();
	
	private String registrationName;   //号别名称
	private String registrationCode;   //号别编号
	private boolean isDefault;         //是否默认
	private String orderCode;          //顺序号
	private float registrationFee;     //挂号费
	
	public Registration(String registrationName, String registrationCode, boolean isDefault, String orderCode,
			float registrationFee) {
		super();
		this.registrationName = registrationName;
		this.registrationCode = registrationCode;
		this.isDefault = isDefault;
		this.orderCode = orderCode;
		this.registrationFee = registrationFee;
	}

	public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public float getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(float registrationFee) {
		this.registrationFee = registrationFee;
	}

	@Override
	public String toString() {
		return "Registration [registrationName=" + registrationName + ", registrationCode=" + registrationCode
				+ ", isDefault=" + ("是".equals(registrationMap.get(registrationCode).isDefault())? "是": "否") + ", orderCode=" + orderCode + ", registrationFee=" + registrationFee
				+ "]";
	}
	
	
	
	

}
