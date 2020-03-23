package com.employeeManagement.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employeeManagement.demo.model.Employee;

@Repository
public interface EmployeeDao {

	public List<Employee> getAllEmployees();
}
