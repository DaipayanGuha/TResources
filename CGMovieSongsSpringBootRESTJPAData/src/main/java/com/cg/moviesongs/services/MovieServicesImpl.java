package com.cg.moviesongs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.moviesongs.beans.Movie;
import com.cg.moviesongs.beans.Song;
import com.cg.moviesongs.daoservices.MovieDAO;
import com.cg.moviesongs.daoservices.SongDAO;
import com.cg.moviesongs.exceptions.MovieNotFoundException;

@Component("movieServices")
public class MovieServicesImpl implements MovieServices{
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private SongDAO songDAO;

	@Override
	public Movie acceptMovieDetails(Movie movie) {
		movie=movieDAO.save(movie);
		return movie;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws MovieNotFoundException {
		return movieDAO.findById(movieId).orElseThrow(()->  new MovieNotFoundException("Movie Details Not found for ID. : "+movieId));
	}

	@Override
	public List<Movie> getAllMovieDetails() {
		return movieDAO.findAll();
	}

	@Override
	public boolean removeMovieDetails(int movieId) throws MovieNotFoundException {
		movieDAO.delete(getMovieDetails(movieId));
		return true;
	}

	@Override
	public Song acceptSongDetails(int movieId, Song song) throws MovieNotFoundException {
		Movie movie = getMovieDetails(movieId);
		song.setMovie(movie);
		songDAO.save(song);
		return song;
	}
	
	
}
