package com.appland.quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.appland.quiz.DAO.Question;
import com.appland.quiz.models.Company;
import com.appland.quiz.models.SubTopic;
import com.appland.quiz.repositories.CompanyRepo;
import com.appland.quiz.repositories.QuestionRepo;
import com.appland.quiz.repositories.SubTopicRepo;
import com.appland.quiz.repositories.TagRepo;
import com.appland.quiz.repositories.UserRepo;
@Component
public class QuestionService {
	@Autowired
	private QuestionRepo qr;
	@Autowired
	private CompanyRepo cr;
	@Autowired
	private SubTopicRepo str;
	@Autowired
	private TagRepo tr;
	@Autowired
	private UserRepo ur;
	public long saveQuestion(Question q)
	{
		com.appland.quiz.models.Question question=new com.appland.quiz.models.Question(0,q.getText());
		qr.save(question);
		long qid=question.getQuestionId();
		if(q.getCompanyId()!=0) {
			Company c=cr.findById(q.getCompanyId()).orElseThrow();
			List<Long> l= c.getQuestionIdList();
			l.add(qid);
			c.setQuestionIdList(l);
			cr.save(c);
		}
		if(q.getSubTopicId()!=0) {
			SubTopic st=str.findById(q.getSubTopicId()).orElseThrow();
			List<Long> l= st.getQuestionIdList();
			l.add(qid);
			st.setQuestionIdList(l);
			str.save(st);
		}
		if(q.getSubTopicId()!=0) {
			SubTopic st=str.findById(q.getSubTopicId()).orElseThrow();
			List<Long> l= st.getQuestionIdList();
			l.add(qid);
			st.setQuestionIdList(l);
			str.save(st);
		}
		return qid;
		
	}
}
