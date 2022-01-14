package com.saprojects.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saprojects.dsmovie.dto.MovieDTO;
import com.saprojects.dsmovie.service.MovieService;

@RestController
@RequestMapping(value = "movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return movieService.findById(id);
	}
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieService.findAll(pageable);
	}

}
