package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

}
