package com.cg.moviesongs.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.moviesongs.beans.Movie;

public interface MovieDAO extends JpaRepository<Movie, Integer>{

}
