package com.employeeManagement.demo.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionAdvice {	
	
	@ExceptionHandler({EmployeeException.class})
    public ResponseEntity<String> handle(EmployeeException e) {
		JSONObject obj = new JSONObject();
		obj.put("exception", e.getMessage());
		return new ResponseEntity<>(obj.toString(), null, HttpStatus.NOT_FOUND);
	}
}
