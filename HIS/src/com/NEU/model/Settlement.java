package com.NEU.model;

import java.util.HashMap;
import java.util.Map;

public class Settlement {                   //结算类别
	
	public static Map<String , Settlement> settlementMap = new HashMap<>();
	
	private String settlementName;          //类别名称
	private String settlementCode;          //类别编号
	
	public Settlement(String settlementName, String settlementCode) {
		super();
		this.settlementName = settlementName;
		this.settlementCode = settlementCode;
	}

	public String getSettlementName() {
		return settlementName;
	}

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	public String getSettlementCode() {
		return settlementCode;
	}

	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}

	@Override
	public String toString() {
		return "Settlement [settlementName=" + settlementName + ", settlementCode=" + settlementCode + "]";
	}
	

}
