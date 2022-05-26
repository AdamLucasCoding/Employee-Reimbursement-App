package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA is the Java Persistence API
//This API allows us access to annotations that can map our fields to DB columns and constraints

@Entity
@Table(name = "Employees") // now the table will show up as 'Employees' instead of 'Employee' (the name of
							// the class) in the database
public class Employee {

	@Id // specifies this field as a primary key
	@Column(name = "Employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this is equivalent to the SERIAL keyword in SQL
	private int employeeId;

	@Column(name = "Employee_name", unique = true, nullable = false) // similar to adding UNIQUE NOT NULL constraint in
																		// SQL
	private String employeeName;

	// this will automatically be created as a column called "description" in the
	// database
	

	@Column(name = "Employee_password", unique = true, nullable = false)
	private String password;

	public Employee() {
		super();
	}



	public Employee(String employeeName, String password) {
		super();
		this.employeeName = employeeName;
		this.password = password;
	}



	public Employee(int employeeId, String employeeName, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
	}



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int EmployeeId) {
		this.employeeId = EmployeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String EmployeeName) {
		this.employeeName = EmployeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password + "]";
	}
	
	
} // this is equivalent to the SERIAL keyword in SQL