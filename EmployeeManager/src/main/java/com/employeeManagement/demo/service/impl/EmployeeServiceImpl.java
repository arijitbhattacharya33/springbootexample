package com.employeeManagement.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employeeManagement.demo.dao.EmployeeDao;
import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
