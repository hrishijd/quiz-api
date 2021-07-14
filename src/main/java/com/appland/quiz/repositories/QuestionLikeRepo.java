package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.QuestionLike;

@Repository
public interface QuestionLikeRepo extends JpaRepository<QuestionLike, Long>{
	
}
