package com.saprojects.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saprojects.dsmovie.entities.Score;
import com.saprojects.dsmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
