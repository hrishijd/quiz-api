package com.appland.quiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.repositories.CompanyRepo;

@RestController("/")
public class CrudController {
	@Autowired
	private CompanyRepo companyRepo;
	@RequestMapping(method = RequestMethod.POST,value = "company/new")
	public void Company(@RequestBody com.appland.quiz.models.Company company) 
	{
		System.out.println(company.toString());
		companyRepo.save(company);
		System.out.println("Hrishi here");
	}
	@RequestMapping(method = RequestMethod.GET,value = "/")
	public void test()
	{
		System.out.println("Hrishi here");
	}
}
