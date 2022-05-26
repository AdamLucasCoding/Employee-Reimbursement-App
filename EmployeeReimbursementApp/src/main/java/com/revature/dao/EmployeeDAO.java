package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	
	
public int insert(Employee e);
	
	public Employee selectById(int id);
	
	public Employee selectByEmployeeName(String employeeName);
	
	public List<Employee> selectAll();
	
	public boolean update(Employee e);
	
	public boolean delete(Employee e);

	

}
