package com.appland.quiz.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appland.quiz.models.Company;
import com.appland.quiz.models.SubTopic;
import com.appland.quiz.models.Tag;
import com.appland.quiz.models.Topic;
import com.appland.quiz.repositories.CompanyRepo;
import com.appland.quiz.repositories.SubTopicRepo;
import com.appland.quiz.repositories.TagRepo;
import com.appland.quiz.repositories.TopicRepo;

@RestController("/")
public class CrudController {
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private TopicRepo topicRepo;
	@Autowired
	private SubTopicRepo subTopicRepo;
	@Autowired
	private TagRepo tagRepo;
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
		return topic.getTopicId();
	}
	@RequestMapping(method = RequestMethod.POST,value = "subtopic/new")
	public Long saveSubTopic(@RequestBody SubTopic subTopic) 
	{
		System.out.println(subTopic.toString());
		subTopicRepo.save(subTopic);
		System.out.println("Hrishi here");
		return subTopic.getSubTopicId();
	}
	@RequestMapping(method = RequestMethod.POST,value = "tag/new")
	public Long saveTag(@RequestBody Tag tag) 
	{
		System.out.println(tag.toString());
		tagRepo.save(tag);
		System.out.println("Hrishi here");
		return tag.getTagId();
	}
	@RequestMapping(method = RequestMethod.GET,value = "company/{id}")
	public Company getCompany(@PathVariable(name="id") long id) 
	{
		try{return companyRepo.findById(id).orElseThrow();}
		catch(NoSuchElementException e)
		{
			return new Company();
		}
	}
	@RequestMapping(method = RequestMethod.GET,value = "topic/{id}")
	public Topic getTopic(@PathVariable(name="id") long id) 
	{
		try{return topicRepo.findById(id).orElseThrow();}
		catch(NoSuchElementException e)
		{
			return new Topic();
		}
	}
	@RequestMapping(method = RequestMethod.GET,value = "subtopic/{id}")
	public SubTopic getSubTopic(@PathVariable(name="id") long id) 
	{
		try{return subTopicRepo.findById(id).orElseThrow();}
		catch(NoSuchElementException e)
		{
			return new SubTopic();
		}
	}
	@RequestMapping(method = RequestMethod.GET,value = "tag/{id}")
	public Tag getTag(@PathVariable(name="id") long id) 
	{
		try{return tagRepo.findById(id).orElseThrow();}
		catch(NoSuchElementException e)
		{
			return new Tag();
		}
	}
	@RequestMapping(method = RequestMethod.PUT,value = "company/{id}")
	public Company updateCompany(@RequestBody com.appland.quiz.models.Company company,@PathVariable(name="id") long id) 
	{
		try{
			Company c=companyRepo.findById(id).orElseThrow();
			c.setName(company.getName());
			companyRepo.save(c);
			return companyRepo.findById(id).orElseThrow();
		}
		catch(NoSuchElementException e)
		{
			return new Company();
		}
	}
	@RequestMapping(method = RequestMethod.PUT,value = "topic/{id}")
	public Topic updateTopic(@RequestBody Topic topic,@PathVariable(name="id") long id) 
	{
		try{
			Topic t=topicRepo.findById(id).orElseThrow();
			t.setName(topic.getName());
			topicRepo.save(t);
			return topicRepo.findById(id).orElseThrow();
		}
		catch(NoSuchElementException e)
		{
			return new Topic();
		}
	}
	@RequestMapping(method = RequestMethod.PUT,value = "subtopic/{id}")
	public SubTopic updateSubTopic(@RequestBody SubTopic subTopic,@PathVariable(name="id") long id) 
	{
		try{
			SubTopic s=subTopicRepo.findById(id).orElseThrow();
			s.setName(subTopic.getName());
			subTopicRepo.save(s);
			return subTopicRepo.findById(id).orElseThrow();
		}
		catch(NoSuchElementException e)
		{
			return new SubTopic();
		}
	}
	@RequestMapping(method = RequestMethod.PUT,value = "tag/{id}")
	public Tag updateTag(@RequestBody Tag tag,@PathVariable(name="id") long id) 
	{
		try{
			Tag t=tagRepo.findById(id).orElseThrow();
			t.setName(tag.getName());
			tagRepo.save(t);
			return tagRepo.findById(id).orElseThrow();
		}
		catch(NoSuchElementException e)
		{
			return new Tag();
		}
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "company/{id}")
	public void deleteCompany(@PathVariable(name="id") long id) 
	{
		companyRepo.deleteById(id);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "topic/{id}")
	public void deleteTopic(@PathVariable(name="id") long id) 
	{
		topicRepo.deleteById(id);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "subtopic/{id}")
	public void deleteSubTopic(@PathVariable(name="id") long id) 
	{
		subTopicRepo.deleteById(id);
	}
	@RequestMapping(method = RequestMethod.DELETE,value = "tag/{id}")
	public void deleteTag(@PathVariable(name="id") long id) 
	{
		tagRepo.deleteById(id);
	}
}
