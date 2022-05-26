package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class EmployeeReimburseApp extends HttpServlet {
	
	
	private static final long serialVersionUID = 8339100247721381693L;

	private static Logger log = Logger.getLogger(EmployeeReimburseApp.class);
	
	//GET methods are used to retrieve resources from an API 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//save the URI and rewrite it to determine what functionality the Employee is requesting based on that endpoint
		final String URI = req.getRequestURI().replace("/EmployeeReimbursementApp/", "");
		log.info("URI: " + URI);
		
		switch (URI) {
		case "Tickets": // query the DB and return a list of all Employees
			log.info("getting Employee list...");
			RequestHelper.processAllTickets(req, resp);
			break;
		case "Ticket":
			log.info("search Employee by name or id. URI: " + URI);
			RequestHelper.processTicketById(req, resp);
			break;
		case "TicketByStatus":
			log.info("getting Tickets by status. . .");
			RequestHelper.processTicketByStatus(req, resp); 
			break; 
		case "TicketByemployeeId":
			log.info("getting ticket by employeeId. . .");
			RequestHelper.processTicketByEmployeeId(req, resp);
			break; 
		case "Employees": // query the DB and return a list of all Employees
			log.info("getting Employee list...");
			RequestHelper.processAllEmployees(req, resp);
			break;
		case "Employee":
			log.info("search Employee by name or id. URI: " + URI);
			RequestHelper.processEmployeeById(req, resp);
			break;
		case "Manager":
			log.info("search Manager by id. URI: " + URI);
			RequestHelper.processManagerById(req, resp);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(req, resp);
			break;
		}
	}
	
	//POST methods are used for creating resources in your API
	//instead of passing data within the URL, it safely passes that info only in the body
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//save the URI and rewrite it to determine what functionality the Employee is requesting based on that endpoint
		final String URI = req.getRequestURI().replace("/EmployeeReimbursementApp/", "");
		log.info("URI: " + URI);
		
		switch (URI) {
		case "registerTicket": 
			log.info("registering new Ticket...");
			RequestHelper.processNewTicket(req, resp);
			break;
		case "registerEmployee": 
			log.info("registering new Employee...");
			RequestHelper.processNewEmployee(req, resp);
			break;
		case "registerManager": 
			log.info("registering new Manager...");
			RequestHelper.processNewManager(req, resp);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(req, resp);
			break;
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//save the URI and rewrite it to determine what functionality the Employee is requesting based on that endpoint
		final String URI = req.getRequestURI().replace("/EmployeeReimbursementApp/", "");
		log.info("URI: " + URI);
		
		switch (URI) {
		case "updateTicket": 
			log.info("updating Employee...");
			RequestHelper.processTicketUpdate(req, resp);
			break;
		case "updateEmployee": 
			log.info("updating Employee...");
			RequestHelper.processEmployeeUpdate(req, resp);
			break;
		case "updateManager": 
			log.info("updating Manager...");
			RequestHelper.processManagerUpdate(req, resp);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(req, resp);
			break;
		}
	}
	

}
