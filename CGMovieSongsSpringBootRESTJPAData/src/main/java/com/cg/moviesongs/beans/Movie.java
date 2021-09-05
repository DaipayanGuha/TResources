package com.cg.moviesongs.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
	private int movieTime;
	private String movieDirector;
	
	@MapKey
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER/* , cascade=CascadeType.ALL */)
	public Map<Integer, Song> songs = new HashMap<Integer, Song>();

	public Movie() {}

	public Movie(int movieId, String movieName, int movieTime, String movieDirector, Map<Integer, Song> songs) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieTime = movieTime;
		this.movieDirector = movieDirector;
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

	public int getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
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
		result = prime * result + ((movieDirector == null) ? 0 : movieDirector.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + movieTime;
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
		if (movieDirector == null) {
			if (other.movieDirector != null)
				return false;
		} else if (!movieDirector.equals(other.movieDirector))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (movieTime != other.movieTime)
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
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieTime=" + movieTime
				+ ", movieDirector=" + movieDirector + ", songs=" + songs + "]";
	}
	
}
