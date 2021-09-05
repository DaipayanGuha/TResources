package com.cg.moviesongs.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.moviesongs.beans.CustomResponse;
import com.cg.moviesongs.exceptions.MovieNotFoundException;

@ControllerAdvice
public class MovieExceptionAspect {
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<CustomResponse> handelMovieDetailsNotFoundException(Exception e){
		CustomResponse response = new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
