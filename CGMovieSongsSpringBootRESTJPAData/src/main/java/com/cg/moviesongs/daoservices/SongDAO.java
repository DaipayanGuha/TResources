package com.cg.moviesongs.daoservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.moviesongs.beans.Movie;
import com.cg.moviesongs.beans.Song;

public interface SongDAO extends JpaRepository<Song, Integer>{
	
	@Query("from Song s where s.movie.movieId=:movieId")
	public List<Song> showSongs(@Param("movieId") int movieId);
	
}
