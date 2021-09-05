package com.cg.cgemployeeaddresss.services;

import java.util.List;

import com.cg.cgemployeeaddresss.beans.Employee;
import com.cg.cgemployeeaddresss.exceptions.EmployeeNotFoundException;

public interface EmployeeServices {

	Employee acceptEmployeeDetails(Employee employee);

	Employee getEmployeeDetails(int employeeId)throws EmployeeNotFoundException;

	List<Employee>  getAllEmployeeDetails() ;
	
	//boolean updateEmployeeAddress(int employeeId)throws EmployeeNotFoundException;
	
	boolean removeEmployeeDetails(int employeeId)throws EmployeeNotFoundException;
	
	
}
