package com.appland.quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appland.quiz.DAO.Answer;
import com.appland.quiz.DAO.Question;
import com.appland.quiz.models.AnswerLike;
import com.appland.quiz.models.Comment;
import com.appland.quiz.models.Company;
import com.appland.quiz.models.QuestionLike;
import com.appland.quiz.models.SubTopic;
import com.appland.quiz.models.Tag;
import com.appland.quiz.models.UserPerson;
import com.appland.quiz.repositories.AnswerLikeRepo;
import com.appland.quiz.repositories.AnswerRepo;
import com.appland.quiz.repositories.CommentRepo;
import com.appland.quiz.repositories.CompanyRepo;
import com.appland.quiz.repositories.QuestionLikeRepo;
import com.appland.quiz.repositories.QuestionRepo;
import com.appland.quiz.repositories.SubTopicRepo;
import com.appland.quiz.repositories.TagRepo;
import com.appland.quiz.repositories.UserRepo;
@Component
public class PostService {
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
	@Autowired
	private AnswerRepo ar;
	@Autowired
	private CommentRepo cmr;
	@Autowired
	private QuestionLikeRepo qlr;
	@Autowired
	private AnswerLikeRepo alr;
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
		if(!q.getTagIdList().isEmpty()) {
			List<Long> l=q.getTagIdList();
			for(Long s:l)
			{
				Tag t=tr.findById(s).orElseThrow();
				List<Long> list=t.getQuestionIdlist();
				l.add(qid);
				t.setQuestionIdlist(list);
				tr.save(t);
		
			}
		}
			
		if(q.getUserId()!=0) {
			UserPerson u=ur.findById(q.getUserId()).orElseThrow();
			List<Long> l= u.getQuestionIdList();
			l.add(qid);
			u.setQuestionIdList(l);
			ur.save(u);
		}
		return qid;
		}
	public long saveAnswer(Answer ans)
	{
		com.appland.quiz.models.Answer answer=new com.appland.quiz.models.Answer(0, ans.getText(), ans.getQuestionId());
		ar.save(answer);
		long aid=answer.getAnswerId();
		if(ans.getUserId()!=0) {
			UserPerson u=ur.findById(ans.getUserId()).orElseThrow();
			List<Long> l= u.getAnswerIdList();
			l.add(aid);
			u.setAnswerIdList(l);
			ur.save(u);
		}
		return aid;
		}
	public long	 saveComment(Comment comment)
	{
		cmr.save(comment);
		return comment.getCommentId();
	}
	public long saveQuestionLike(QuestionLike ql)
	{
		qlr.save(ql);
		return ql.getQuestionLikeId();
	}
	public long saveAnswerLike(AnswerLike al)
	{
		alr.save(al);
		return al.getAnswerLikeId();
	}
}
