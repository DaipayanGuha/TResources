package com.cg.cgemployeeaddresss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.cgemployeeaddresss.beans.Employee;
import com.cg.cgemployeeaddresss.exceptions.EmployeeNotFoundException;
import com.cg.cgemployeeaddresss.services.EmployeeServices;

@Controller
public class EmployeeServicesController {

	@Autowired
	EmployeeServices employeeServices;

	@RequestMapping(value={"/getEmployeeDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json") 
	public ResponseEntity<Employee> getEmployeeDetailsRequestParam(@RequestParam int employeeId)throws EmployeeNotFoundException{ 
		Employee employee = employeeServices.getEmployeeDetails(employeeId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK); 
	}

	@RequestMapping(value= {"/getAllEmployeeDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Employee>>getEmployeeDetailsPathParam(){
		return new ResponseEntity<List<Employee>>(employeeServices.getAllEmployeeDetails(),HttpStatus.OK);
	}

	@RequestMapping(value= {"/acceptEmployeeDetails"},method=RequestMethod.POST,produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>acceptEmployeeDetails(@ModelAttribute Employee employee){
		employee = employeeServices.acceptEmployeeDetails(employee);
		return new ResponseEntity<>("Employee Details successfully added with Employee ID.: " + employee.getEmployeeId(),HttpStatus.OK);
	}

	@RequestMapping(value= {"/removeEmployeeDetails"},method=RequestMethod.DELETE,produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>removeEmployeeDetails(@RequestParam int employeeId)throws EmployeeNotFoundException{
		employeeServices.removeEmployeeDetails(employeeId);
		return new ResponseEntity<>("Employee Details successfully removed",HttpStatus.OK);
	}
}
