package com.employeeManagement.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of a Department")
@Entity
@Table(name = "department_details")
public class Department {

	@ApiModelProperty(notes = "Department Id")
	@Id
	@Column(name = "dept_id", updatable = false, nullable = false)
	private String deptId;

	@ApiModelProperty(notes = "Department Name")
	@Column(name = "dept_name")
	private String deptName;

	@ApiModelProperty(notes = "Department Description")
	@Column(name = "dept_information")
	private String deptInformation;

	//@Transient
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employee;

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

	@JsonBackReference
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}	
}
