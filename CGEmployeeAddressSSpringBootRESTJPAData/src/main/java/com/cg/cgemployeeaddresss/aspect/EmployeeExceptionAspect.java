package com.cg.cgemployeeaddresss.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.cgemployeeaddresss.beans.CustomResponse;
import com.cg.cgemployeeaddresss.exceptions.EmployeeNotFoundException;


@ControllerAdvice
public class EmployeeExceptionAspect {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<CustomResponse> handelEmployeeNotFoundException(Exception e){
		CustomResponse response = new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}

}
