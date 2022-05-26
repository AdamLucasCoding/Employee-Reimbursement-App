package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.ERSMainDAO;
import com.revature.dao.ERSMainDAOImpl;
import com.revature.models.ERSMain;

public class ERSMainServiceImpl implements ERSMainService {

private ERSMainDAO emdao;	
private static Logger log = Logger.getLogger(ERSMainServiceImpl.class);	


public ERSMainServiceImpl(ERSMainDAOImpl dao) {
	super();
	this.emdao = dao; 
}
	
	
	@Override
	public int newTicket(ERSMain ticket) {
		log.info("in service layer. Registering Manager: " + ticket);
		return emdao.insert(ticket);
	}

	@Override
	public ERSMain findTicketById(int ticketId) {
		log.info("in service layer. searching Tickets by id: " + ticketId);
		return emdao.selectById(ticketId);
	}

	@Override
	public ERSMain findTicketByEmployee_Id(int employeeId) {
		log.info("in service layer. searching for ticket by employee id: " + employeeId);
		return emdao.selectById(employeeId);
	}

	@Override
	public boolean editTicketStatus(ERSMain ticket) {
		log.info("in service layer. editing ticket status: " + ticket);
		return emdao.update(ticket);
	}

	@Override
	public List<ERSMain> finadallTickets() {
		log.info("in service layer. finding all Tickets...");
		return emdao.selectAll();
	}


	@Override
	public boolean deleteTicket(ERSMain ticket) {
		log.info("in service layer. removing Ticket: " + ticket);
		return emdao.delete(ticket);
	}


	@Override
	public List<ERSMain> findTicketsByStatus() {
		log.info("in service layer. creating a list based on ticket status . . . ");
		return emdao.selectByTicketsStatus(null); 
	}


	@Override
	public ERSMain findTicketByStatus() {
		log.info("in service layer. retrieving based on ticket status . . . ");
		return emdao.selectTicketByStatus(null); 
	}


	

}
