package com.employeeManagement.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_details")
public class Department {

	@Id
	private String deptId;
	private String deptName;
	private String deptInformation;
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptInformation() {
		return deptInformation;
	}
	public void setDeptInformation(String deptInformation) {
		this.deptInformation = deptInformation;
	}
	
	
}
