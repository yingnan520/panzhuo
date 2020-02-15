package com.NEU.model;

import java.io.Serializable;
import java.util.Vector;

public class Disease implements Serializable {                 //疾病
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diseaseName;        //疾病名称
	private String diseaseCode;        //疾病编号
	private String parentCode;         //父亲编号
	private String spellCode;         //拼音码
	private String wubiCode;          //五笔码
	public Vector<Disease> subDisease = new Vector<Disease>();     //储存子病信息
	public Vector<String> patientsList = new Vector<String>();     //储存病人信息 
	
	public Disease(String diseaseName) {
		this.diseaseName = diseaseName;
	};
	
	public Disease(String diseaseName, String diseaseCode, String parentCode, String spellCode, String wubiCode) {
		super();
		this.diseaseName = diseaseName;
		this.diseaseCode = diseaseCode;
		this.parentCode = parentCode;
		this.spellCode = spellCode;
		this.wubiCode = wubiCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getSpellCode() {
		return spellCode;
	}

	public void setSpellCode(String spellCode) {
		this.spellCode = spellCode;
	}

	public String getWubiCode() {
		return wubiCode;
	}

	public void setWubiCode(String wubiCode) {
		this.wubiCode = wubiCode;
	}

	@Override
	public String toString() {
		return "Disease [diseaseName=" + diseaseName + ", subDisease=" + subDisease + ", patientsList=" + patientsList
				+ "]";
	}

}
