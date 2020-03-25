package com.employeeManagement.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Login Details")
@Entity
@Table(name = "login_details")
public class User {

	@ApiModelProperty(notes = "Username")
	@Id
	@Column(name = "username", updatable = false, nullable = false)
	private String username;

	@ApiModelProperty(notes = "Password")
	@Column(name = "password", nullable = false)
	// @ColumnTransformer(read = "", write = )
	private String password;

	@ApiModelProperty(notes = "Role of a User")
	@Column(name = "role", nullable = false)
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
