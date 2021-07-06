package com.appland.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.models.Topic;
import com.appland.quiz.repositories.CompanyRepo;
import com.appland.quiz.repositories.TopicRepo;

@RestController("/")
public class CrudController {
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private TopicRepo topicRepo;
	@RequestMapping(method = RequestMethod.POST,value = "company/new")
	public long saveCompany(@RequestBody com.appland.quiz.models.Company company) 
	{
		System.out.println(company.toString());
		companyRepo.save(company);
		System.out.println("Hrishi here");
		return company.getCompanyId();
	}
	@RequestMapping(method = RequestMethod.POST,value = "topic/new")
	public Long saveTopic(@RequestBody Topic topic) 
	{
		System.out.println(topic.toString());
		topicRepo.save(topic);
		System.out.println("Hrishi here");
		return topic.getTopicID();
	}
	@RequestMapping(method = RequestMethod.GET,value = "/")
	public void test()
	{
		System.out.println("Hrishi here");
	}
}
