package com.saprojects.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saprojects.dsmovie.dto.MovieDTO;
import com.saprojects.dsmovie.dto.ScoreDTO;
import com.saprojects.dsmovie.entities.Movie;
import com.saprojects.dsmovie.entities.Score;
import com.saprojects.dsmovie.entities.User;
import com.saprojects.dsmovie.repositories.MovieRepository;
import com.saprojects.dsmovie.repositories.ScoreRepository;
import com.saprojects.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
	
		Score score = new Score();
		
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s: movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		return new MovieDTO(movie);
	}
	
	
}
















