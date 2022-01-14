package com.saprojects.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saprojects.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
