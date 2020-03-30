package com.golf.golf1.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface RoundRepository extends CrudRepository<Round, Long> {

    List<Round> findByScore(int score);
    
}