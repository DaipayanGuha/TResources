package com.cg.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.movies.beans.Movie;
import com.cg.movies.beans.Song;
import com.cg.movies.daoservices.MovieDAO;
import com.cg.movies.daoservices.SongDAO;
import com.cg.movies.exceptions.MovieNotFoundException;
@Component("movieServices")
public class MovieServicesImpl implements MovieServices {


	@Autowired
	MovieDAO movieDao;
	@Autowired
	SongDAO songDao;
	


	
	@Override
	public Movie saveMovie(Movie movie) {
		return movieDao.save(movie);
	}

	@Override
	public Movie getMovieDetails(int movieId) throws MovieNotFoundException {
		return movieDao.findById(movieId).orElseThrow(()-> new MovieNotFoundException("Movie Not Found with ID : "+movieId));
	}

	@Override
	public List<Movie> getAllMovieDetails() {	
		return movieDao.findAll();
	}

	@Override
	public boolean removeMovieDetails(int movieId) throws MovieNotFoundException {
		movieDao.deleteById(movieId);
		return true;
	}

	@Override
	public Song saveSongs(int movieId, Song song) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Movie movie = getMovieDetails(movieId);
		song.setMovie(movie);
		songDao.save(song);
		return song;
	}

}
