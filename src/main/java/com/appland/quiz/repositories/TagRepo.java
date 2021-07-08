package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.Tag;
@Repository
public interface TagRepo extends JpaRepository<Tag, Long>{

}
