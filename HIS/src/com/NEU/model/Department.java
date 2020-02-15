package com.NEU.model;

public abstract class Department {             //科室
	
	protected String departmentName;    //科室名称
	protected String departmentCode;    //科室编号
	
	public Department(String departmentName, String departmentCode) {
		super();
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
	}

	public abstract String getDepartmentName();

	public abstract void setDepartmentName(String departmentName);

	public abstract String getDepartmentCode();

	public abstract void setDepartmentCode(String departmentCode);

}
