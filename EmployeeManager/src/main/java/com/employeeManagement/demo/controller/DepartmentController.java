package com.employeeManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.demo.aspect.MyLoggable;
import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	
}