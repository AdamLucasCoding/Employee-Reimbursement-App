package com.revature.dao;

import java.util.List;

import com.revature.models.Manager;

public interface ManagerDAO {

	public int insert(Manager Manager);

	public Manager selectById(int managerId);

	public Manager selectByFirstName(String firstName);

	public List<Manager> selectAll();

	public boolean update(Manager Manager);

	public boolean delete(Manager Manager);
	
	
	
	

}