package com.employeeManagement.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.demo.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@RequestMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
}
