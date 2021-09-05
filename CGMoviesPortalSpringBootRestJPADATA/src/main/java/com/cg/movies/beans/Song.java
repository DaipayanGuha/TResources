package com.cg.movies.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int songId;
	private String songName;
	@ManyToOne
	private Movie movie;
	
	public Song() {}
	

	
	public Song(String songName) {
		super();
		this.songName = songName;
	}



	public Song(String songName, Movie movie) {
		super();
		this.songName = songName;
		this.movie = movie;
	}


	public Song(int songId, String songName, Movie movie) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.movie = movie;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + songId;
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
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
		Song other = (Song) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (songId != other.songId)
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}
	
	
}
