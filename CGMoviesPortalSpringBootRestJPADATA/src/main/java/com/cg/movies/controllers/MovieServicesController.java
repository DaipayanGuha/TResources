package com.cg.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.movies.beans.Movie;
import com.cg.movies.beans.Song;
import com.cg.movies.exceptions.MovieNotFoundException;
import com.cg.movies.services.MovieServices;


@Controller
public class MovieServicesController {

	
	@Autowired 
	MovieServices movieServices;
	
	@RequestMapping(value="/saveMovie",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> saveMoviesParam(@ModelAttribute Movie movie){
		movie=movieServices.saveMovie(movie);
		return new ResponseEntity<String>("Movie details successfully added . MovieId: "+movie.getMovieId(),HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value=
	 * {"/getMovieDetails/{movieId}"},method=RequestMethod.GET,
	 * produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	 * public ResponseEntity<Movie>
	 * getMovieDetailsPathParam(@PathVariable(value="movieId")int movieId) throws
	 * MovieNotFoundException{ Movie movie = movieServices.getMovieDetails(movieId);
	 * return new ResponseEntity<Movie>(movie,HttpStatus.OK); }
	 */

	
	@RequestMapping(value="/getMovieDetails", method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<Movie> getMovieDetails(@RequestParam int movieId) throws MovieNotFoundException {
		return new ResponseEntity<Movie>(movieServices.getMovieDetails(movieId),HttpStatus.OK);
	}
	
	
	@RequestMapping(value= {"/getAllMovieDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<List<Movie>> getAllAssociateDetailspathParam(){
		return new ResponseEntity<List<Movie>>(movieServices.getAllMovieDetails(),HttpStatus.OK);
	}
	

	@RequestMapping(value="/removeMovieDetails",method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> removeMovieDetails(@RequestParam int movieId) throws MovieNotFoundException{
		movieServices.removeMovieDetails(movieId);
		return new ResponseEntity<>("Movie Details successfully removed",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/saveSong",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> saveSongsParam(@RequestParam int movieId, @ModelAttribute Song song) throws MovieNotFoundException{
		Song s = movieServices.saveSongs(movieId, song);
		return new ResponseEntity<String>("Song details entered successfully for movieId"+movieId+" and songId "+s.getSongId(),HttpStatus.OK);
	}
	

}
