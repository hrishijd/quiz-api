package com.appland.quiz.DAO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionDetail {
	private String text;
	private long likes;
	private List<String> companyDetail;
	private List<String> tags;
	private List<String> Topics;
	private List<AnswerDetail> answers;
}
