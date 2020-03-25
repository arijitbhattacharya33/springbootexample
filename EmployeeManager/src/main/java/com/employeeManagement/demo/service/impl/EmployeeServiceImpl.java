package com.employeeManagement.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.demo.dao.EmployeeDao;
import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return null;// employeeDao.getAllEmployees();
	}

}
