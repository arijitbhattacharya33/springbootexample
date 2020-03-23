package com.employeeManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value="Retrive all the employees", notes = "This api returns all the employees of the company.", response = List.class)
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employeeList = null; //employeeService.getAllEmployees();		
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
}
