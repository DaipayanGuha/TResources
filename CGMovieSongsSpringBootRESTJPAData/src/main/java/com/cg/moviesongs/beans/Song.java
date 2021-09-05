package com.cg.moviesongs.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int songId;
	
	private String songName;
	private String songSinger;
	private int songDuration;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	Movie movie;
	
	public Song() {}

	public Song(int songId, String songName, String songSinger, int songDuration, Movie movie) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.songSinger = songSinger;
		this.songDuration = songDuration;
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

	public String getSongSinger() {
		return songSinger;
	}

	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}

	public int getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(int songDuration) {
		this.songDuration = songDuration;
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
		result = prime * result + songDuration;
		result = prime * result + songId;
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		result = prime * result + ((songSinger == null) ? 0 : songSinger.hashCode());
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
		if (songDuration != other.songDuration)
			return false;
		if (songId != other.songId)
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		if (songSinger == null) {
			if (other.songSinger != null)
				return false;
		} else if (!songSinger.equals(other.songSinger))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", songSinger=" + songSinger + ", songDuration="
				+ songDuration + ", movie=" + movie + "]";
	}
	
}
