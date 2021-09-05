package com.cg.movies.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String movieGenre;
	@OneToMany(mappedBy="movie", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@MapKey
	private Map<Integer, Song> songs = new HashMap<Integer, Song>();
	
	public Movie() {}
	

	public Movie(String movieName, String movieGenre, Map<Integer, Song> songs) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.songs = songs;
	}


	public Movie(int movieId, Map<Integer, Song> songs) {
		super();
		this.movieId = movieId;
		this.songs = songs;
	}


	public Movie(String movieName, String movieGenre) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
	}


	public Movie(int movieId, String movieName, String movieGenre, Map<Integer, Song> songs) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.songs = songs;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getMovieGenre() {
		return movieGenre;
	}


	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}


	public Map<Integer, Song> getSongs() {
		return songs;
	}


	public void setSongs(Map<Integer, Song> songs) {
		this.songs = songs;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieGenre == null) ? 0 : movieGenre.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieGenre == null) {
			if (other.movieGenre != null)
				return false;
		} else if (!movieGenre.equals(other.movieGenre))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", songs="
				+ songs + "]";
	}
	
	

	
	
}
