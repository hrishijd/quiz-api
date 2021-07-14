package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.AnswerLike;
@Repository
public interface AnswerLikeRepo extends JpaRepository<AnswerLike, Long>{

}
