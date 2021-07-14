package com.appland.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.TrueCondition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.DAO.Question;
import com.appland.quiz.services.QuestionService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@RestController
public class PostController {
	@Autowired
	QuestionService qs;
	  @RequestMapping(method = RequestMethod.POST,value ="/post/question") 
	  public long postQuestion(@RequestBody Question question) 
	  {
		  long qid=qs.saveQuestion(question);
		  return qid;
	  }
}
