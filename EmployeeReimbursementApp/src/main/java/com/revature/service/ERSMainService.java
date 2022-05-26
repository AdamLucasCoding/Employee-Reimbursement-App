package com.revature.service;

import java.util.List;

import com.revature.models.ERSMain;


public interface ERSMainService {
	
	public int newTicket(ERSMain ticket);
	
	public ERSMain findTicketById(int ticketId);
	
	public ERSMain findTicketByEmployee_Id(int id);
	
	//this will let you edit whole ticket, but you can just edit status here. 
	public boolean editTicketStatus(ERSMain ticket);
	
	public boolean deleteTicket(ERSMain ticket);
	
	public List<ERSMain> finadallTickets();
	
	public List<ERSMain> findTicketsByStatus(); 
	
	public ERSMain findTicketByStatus(); 
}
