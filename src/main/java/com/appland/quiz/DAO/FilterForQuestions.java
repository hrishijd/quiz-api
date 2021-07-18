package com.appland.quiz.DAO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterForQuestions {
	List<Long> companyIdList;
	List<Long> subTopicIdList;
	long questionLikes;
	List<Long> tagIdList;
}

