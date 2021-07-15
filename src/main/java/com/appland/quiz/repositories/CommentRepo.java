package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>{

}
