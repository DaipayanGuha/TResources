package com.cg.moviesongs.services;

import java.util.List;

import com.cg.moviesongs.beans.Movie;
import com.cg.moviesongs.beans.Song;
import com.cg.moviesongs.exceptions.MovieNotFoundException;

public interface MovieServices {
	
	Movie acceptMovieDetails(Movie movie);
	
	Song acceptSongDetails(int movieId, Song song)throws MovieNotFoundException;

	Movie getMovieDetails(int movieId) throws MovieNotFoundException;
	List<Movie> getAllMovieDetails();

	boolean removeMovieDetails(int movieId)throws MovieNotFoundException;
}
