package com.employeeManagement.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of An Employee")
@Entity
@Table(name = "employee_details")
public class Employee {

	@ApiModelProperty(notes = "Employee Id")
	@Id
	@Column(name = "emp_id", updatable = false, nullable = false)
	private String employeeId;

	@ApiModelProperty(notes = "Employee Name")
	@Column(name = "emp_name")
	private String name;

	@ApiModelProperty(notes = "Employee Address")
	@Column(name = "address")
	private String address;

	@ApiModelProperty(notes = "Employee City")
	@Column(name = "city")
	private String city;

	@ApiModelProperty(notes = "Employee Pincode")
	@Column(name = "pin")
	private String pincode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Department department;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@JsonManagedReference
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
