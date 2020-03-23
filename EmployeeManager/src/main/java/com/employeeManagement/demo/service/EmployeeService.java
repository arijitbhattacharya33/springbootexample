package com.employeeManagement.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagement.demo.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();
}
