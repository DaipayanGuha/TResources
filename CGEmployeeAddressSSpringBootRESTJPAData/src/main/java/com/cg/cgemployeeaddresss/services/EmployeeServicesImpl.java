package com.cg.cgemployeeaddresss.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.cgemployeeaddresss.beans.Address;
import com.cg.cgemployeeaddresss.beans.Employee;
import com.cg.cgemployeeaddresss.daoservices.EmployeeDAO;
import com.cg.cgemployeeaddresss.exceptions.EmployeeNotFoundException;

@Component("employeeServices")
public class EmployeeServicesImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee acceptEmployeeDetails(Employee employee) {
		employee=employeeDAO.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployeeDetails(int employeeId) throws EmployeeNotFoundException {
		return employeeDAO.findById(employeeId).orElseThrow(()->  new EmployeeNotFoundException("Employee Details Not found for Employee ID. : "+employeeId));
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return employeeDAO.findAll();
	}

	
	/*
	 * @Override public boolean updateEmployeeAddress(int employeeId) throws
	 * EmployeeNotFoundException { Employee employee =
	 * getEmployeeDetails(employeeId); if(employee==null) throw new
	 * EmployeeNotFoundException("Employee Details Not found for Employee ID. : "
	 * +employeeId); employee.getAddress(); employee.setAddress(new Address(road,
	 * city, state, pincode)); employee.save(employee); return true; }
	 */
	 

	@Override
	public boolean removeEmployeeDetails(int employeeId) throws EmployeeNotFoundException {
		employeeDAO.delete(getEmployeeDetails(employeeId));
		return true;
	}

	

}
