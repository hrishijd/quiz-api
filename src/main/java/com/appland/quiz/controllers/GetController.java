package com.appland.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.DAO.FilterForQuestions;
import com.appland.quiz.DAO.FilteredQuestion;
import com.appland.quiz.DAO.QuestionDetail;
import com.appland.quiz.services.GetService;

@RestController
public class GetController {
	@Autowired
	private GetService gs;
	@RequestMapping(method = RequestMethod.GET, value = "/get/questions")
	public List<FilteredQuestion> getquestions(@RequestParam(name= "companyidlist", required = false) List<Long> companyIdList,
			@RequestParam(name= "subtopicidlist" , required = false) List<Long> subTopicIdList
			,@RequestParam(name= "likes", required = false) Long likes
			,@RequestParam(name= "tagidlist", required = false) List<Long> tagIdList)
	{
		FilterForQuestions fq=new FilterForQuestions(companyIdList, subTopicIdList, likes, tagIdList);
		return gs.getQuestion(fq);
	} 
	@RequestMapping(method = RequestMethod.GET, value = "/get/questiondeatails")
	public QuestionDetail getquestiondetails(@RequestParam(name= "id", required = false)Long qid)
	{
		return gs.getQuestionDetails(qid);
	}
}
