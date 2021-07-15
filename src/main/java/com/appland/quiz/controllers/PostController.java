package com.appland.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.TrueCondition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.DAO.Answer;
import com.appland.quiz.DAO.Question;
import com.appland.quiz.models.AnswerLike;
import com.appland.quiz.models.Comment;
import com.appland.quiz.models.QuestionLike;
import com.appland.quiz.services.PostService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@RestController
public class PostController {
	@Autowired
	PostService qs;
	  @RequestMapping(method = RequestMethod.POST,value ="/post/question") 
	  public long postQuestion(@RequestBody Question question) 
	  {
		  long qid=qs.saveQuestion(question);
		  return qid;
	  }
	  @RequestMapping(method = RequestMethod.POST,value ="/post/answer") 
	  public long postAnswer(@RequestBody Answer answer) 
	  {
		  long aid=qs.saveAnswer(answer);
		  return aid;
	  }
	  @RequestMapping(method = RequestMethod.POST,value ="/post/comment") 
	  public long postComment(@RequestBody Comment comment) 
	  {
		  long cid=qs.saveComment(comment);
		  return cid;
	  }
	  @RequestMapping(method = RequestMethod.POST,value ="/post/questionlike") 
	  public long postQuestionLike(@RequestBody  QuestionLike ql) 
	  {
		  long qlid=qs.saveQuestionLike(ql);
		  return qlid;
	  }
	  @RequestMapping(method = RequestMethod.POST,value ="/post/questionlike") 
	  public long postAnswerLike(@RequestBody  AnswerLike al) 
	  {
		  long alid=qs.saveAnswerLike(al);
		  return alid;
	  }
}
