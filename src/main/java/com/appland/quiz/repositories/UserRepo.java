package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.UserPerson;

@Repository
public interface UserRepo extends JpaRepository<UserPerson, Long>{

}
