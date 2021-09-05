package com.cg.cgemployeeaddresss.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cgemployeeaddresss.beans.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
