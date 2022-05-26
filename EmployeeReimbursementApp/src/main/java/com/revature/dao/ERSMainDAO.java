package com.revature.dao;

import java.util.List;

import com.revature.models.ERSMain;



public interface ERSMainDAO {
	
	public int insert(ERSMain ticket);

	public ERSMain selectById(int ticketId);

	public List<ERSMain> selectByemployeeTicketId(int employeeId);
	
	public List<ERSMain> selectByTicketsStatus(String ticketStatus);
	
//	public ERSMain selectTicketByStatus (String ticketStatus); 

	public List<ERSMain> selectAll();

	public boolean update(ERSMain ticket);

	public boolean delete(ERSMain ticket);

}
