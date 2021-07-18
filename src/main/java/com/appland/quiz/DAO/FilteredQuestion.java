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
public class FilteredQuestion {
	private long QuestionId;
	private String text;
	private List<Long> companyIdList;
	private long likes;
	private long answerId;
	private String answer;
}
