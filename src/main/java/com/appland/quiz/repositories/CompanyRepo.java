package com.appland.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appland.quiz.models.Company;
@Repository
public interface CompanyRepo extends JpaRepository<Company,Long>{

}
