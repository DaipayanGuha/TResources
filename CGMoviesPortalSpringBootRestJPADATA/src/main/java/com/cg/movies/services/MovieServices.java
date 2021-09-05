package com.cg.movies.services;

import java.util.List;

import com.cg.movies.beans.Movie;
import com.cg.movies.beans.Song;
import com.cg.movies.exceptions.MovieNotFoundException;

public interface MovieServices {

	
	public Movie saveMovie(Movie movies);
	public Movie getMovieDetails(int movieId)throws MovieNotFoundException;
	public List<Movie>getAllMovieDetails();
	public boolean removeMovieDetails(int movieId) throws MovieNotFoundException;
	public Song saveSongs(int movieId, Song song) throws MovieNotFoundException;
}
