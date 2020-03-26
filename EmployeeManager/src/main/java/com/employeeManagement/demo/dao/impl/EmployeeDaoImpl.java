package com.employeeManagement.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employeeManagement.demo.dao.EmployeeDao;
import com.employeeManagement.demo.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee>  employeeList = session.createQuery("from Department").list();
		return employeeList;
	}

}
