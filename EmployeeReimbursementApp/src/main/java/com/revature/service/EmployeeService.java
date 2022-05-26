package com.revature.service;

import java.util.List;

import com.revature.models.Employee;


public interface EmployeeService {

	public Employee login(String Employeename, String password);
	
	public int register(Employee e);
	
	public Employee findEmployeeById(int id);
	
	public List<Employee> findAllEmployees();//
	
	public boolean editEmployee(Employee e);
	
	
}


