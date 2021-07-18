package com.appland.quiz.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appland.quiz.DAO.AnswerDetail;
import com.appland.quiz.DAO.CommentDetail;
import com.appland.quiz.DAO.FilterForQuestions;
import com.appland.quiz.DAO.FilteredQuestion;
import com.appland.quiz.DAO.Question;
import com.appland.quiz.DAO.QuestionDetail;
import com.appland.quiz.models.Answer;
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
public class GetService {
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
	public List<FilteredQuestion> getQuestion(FilterForQuestions fq)
	{
		List<Question> question=new ArrayList<Question>();
		Set<com.appland.quiz.models.Question> q=new HashSet<com.appland.quiz.models.Question>(qr.findAll());
		if(fq.getCompanyIdList()!=null)
		{
			List<Company> list=cr.findAllById(fq.getCompanyIdList());
			for(Company c:list) 
			{
				q.addAll(qr.findAllById(c.getQuestionIdList()));
			}
		}
		if(fq.getSubTopicIdList()!=null)
		{
			List<SubTopic> list=str.findAllById(fq.getSubTopicIdList());
			for(SubTopic s:list) 
			{
				q.addAll(qr.findAllById(s.getQuestionIdList()));
			}
			
		}
		if(fq.getTagIdList()!=null)
		{
			List<Tag> list=tr.findAllById(fq.getTagIdList());
			for(Tag t:list) 
			{
				q.addAll(qr.findAllById(t.getQuestionIdList()));
			}
		}
		ArrayList<FilteredQuestion> list = new ArrayList<FilteredQuestion>();
		ArrayList<AnswerLike> list1 = new ArrayList<AnswerLike>(alr.findAll());
		ArrayList<Answer> list2 = new ArrayList<Answer>(ar.findAll());
		ArrayList<QuestionLike> list3 = new ArrayList<QuestionLike>(qlr.findAll());
		ArrayList<Company> list4 = new ArrayList<Company>(cr.findAll());
		for(com.appland.quiz.models.Question ques:q)
		{
			FilteredQuestion e=new FilteredQuestion();
			e.setQuestionId(ques.getQuestionId());
			e.setText(ques.getText());
			int likes=0;
		    for(QuestionLike ql:list3)
		    {
		    	if(ql.getQuestionId()==ques.getQuestionId())
		    	{
		    		likes++;
		    	}
		    }
			e.setLikes(likes);
			int maxLike=0;
			String text="";
			long aid=0;
			for(Answer al:list2)
		    {
				
		    	if(al.getQuestionId()==ques.getQuestionId())
		    	{
		    		int like=0;
		    		for(AnswerLike a:list1)
		    		{
		    			if(a.getAnswerId()==al.getAnswerId())
		    			{
		    				like++;
		    			}
		    		}
		    		if(like>maxLike)
		    		{
		    			maxLike=like;
		    			text=al.getText();
		    			aid=al.getAnswerId();
		    		}
		    	}
		    }
			e.setAnswer(text);
			e.setAnswerId(aid);
			List<Long> l=new ArrayList<Long>();
			for(Company c:list4)
			{
				if(c.getQuestionIdList().contains(ques.getQuestionId()))
				{
					l.add(c.getCompanyId());
				}
			}
			e.setCompanyIdList(l);
			list.add(e);
		}
		return list;
	}
	public QuestionDetail getQuestionDetails(long qid)
	{
		QuestionDetail questionDetail=new QuestionDetail();
		com.appland.quiz.models.Question question=qr.findById(qid).orElseThrow();
		List<AnswerDetail> answerDetail=new ArrayList<AnswerDetail>();
		List<Answer> answers=new ArrayList<Answer>(ar.findAll());
		List<UserPerson> users=new ArrayList<UserPerson>(ur.findAll());
		List<AnswerLike> answerLikes=new ArrayList<AnswerLike>(alr.findAll());
		List<QuestionLike> questionLikes=new ArrayList<QuestionLike>(qlr.findAll());
		List<Comment> comments=new ArrayList<Comment>(cmr.findAll());
		List<Company> company=new ArrayList<Company>(cr.findAll());
		List<Tag> tags=new ArrayList<Tag>(tr.findAll());
		List<SubTopic> subTopics=new ArrayList<SubTopic>(str.findAll());
		for(Answer a:answers)
		{
			if(a.getQuestionId()==qid)
			{
				AnswerDetail ad=new AnswerDetail();
				ad.setText(a.getText());
				for(UserPerson user:users)
				{
					if(user.getAnswerIdList().contains(a.getAnswerId()))
					{
						ad.setUserId(user.getUserId());
						break;
					}
				}
				int count=0;
				for(AnswerLike al:answerLikes)
				{
					if(al.getAnswerId()==a.getAnswerId())
					{
						count++;
					}	
				}
				ad.setLikes(count);
				List<CommentDetail> cd=new ArrayList<CommentDetail>();
				for(Comment c:comments)
				{
					if(c.getAnswerId()==a.getAnswerId())
					{
						CommentDetail cda=new CommentDetail(c.getCommentId(), c.getUserId(), c.getText());
						cd.add(cda);
					}
				}
				ad.setCommentList(cd);
				answerDetail.add(ad);
			}
		}
		questionDetail.setAnswers(answerDetail);
		List<String> companyDetail=new ArrayList<String>();
		for(Company c:company)
		{
			if(c.getQuestionIdList().contains(qid))
			{
				companyDetail.add(c.getName());
			}
		}
		questionDetail.setCompanyDetail(companyDetail);
		int count=0;
		for(QuestionLike ql:questionLikes)
		{
			if(ql.getQuestionId()==qid)
			{
				count++;
			}	
		}
		questionDetail.setLikes(count);
		List<String> tag=new ArrayList<String>();
		for(Tag t:tags)
		{
			if(t.getQuestionIdList().contains(qid))
			{
				tag.add(t.getName());
			}
		}
		questionDetail.setTags(tag);
		List<String> topics=new ArrayList<String>();
		for(SubTopic st:subTopics)
		{
			if(st.getQuestionIdList().contains(qid))
			{
				topics.add(tr.findById(st.getTopicId()).orElseThrow().getName());
			}
		}
		questionDetail.setTopics(topics);
		questionDetail.setText(question.getText());
		return questionDetail;
	}
}
