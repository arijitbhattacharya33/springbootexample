package com.employeeManagement.demo.security;

public class AuthenticationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242568843888226921L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
