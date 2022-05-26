package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO edao;
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	//introducing dependency injection through use of a construction injection
	//so we are not manually injecting what we need for this class; we are handing that control over to the application
	public EmployeeServiceImpl(EmployeeDAOImpl dao) {
		super();
		this.edao = dao; //this is the same as this: private static EmployeeDAO udao = new EmployeeDAOImpl();
	}

	@Override
	public Employee login(String Employeename, String password) {
		log.info("in service layer. Logging in Employee with creds: " + Employeename + ", " + password);
		//utilize Streams API
		Optional<Employee> Employees = edao.selectAll()
				.stream()
				.filter(u -> (u.getEmployeeName().equals(Employeename) && u.getPassword().equals(password))) //filter out to all Employees that match criteria/condition
				.findFirst(); //returns the element that is left after filtering
		return (Employees.isPresent() ? Employees.get() : null);
	}

	//@Override
	//public int register(Employee e) {
		//log.info("in service layer. Registering Employee: " + e);
		//return edao.insert(e);
	//}

	@Override
	public Employee findEmployeeById(int id) {
		log.info("in service layer. searching Employee by id: " + id);
		return edao.selectById(id);
	}



	@Override
	public boolean editEmployee(Employee e) {
		log.info("in service layer. editing Employee: " + e);
		return edao.update(e);
	}
	@Override
	public List<Employee> findAllEmployees() {
		log.info("in service layer. finding all Employees...");
		return edao.selectAll();
	}

	@Override
	public int register(Employee e) {
		log.info("in service layer. registering a new Employee...");
		return edao.insert(e);
	}

}
