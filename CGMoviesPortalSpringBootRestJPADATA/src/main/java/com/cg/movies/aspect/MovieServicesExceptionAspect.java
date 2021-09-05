package com.cg.movies.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.movies.beans.MovieResponse;
import com.cg.movies.exceptions.MovieNotFoundException;
@ControllerAdvice
public class MovieServicesExceptionAspect {

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<MovieResponse>  handelMovieNotFoundException(Exception e){
		MovieResponse response = new MovieResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
	