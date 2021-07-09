package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.Topic;

@Repository
public interface TopicRepo extends JpaRepository<Topic,Long>{
	
}
