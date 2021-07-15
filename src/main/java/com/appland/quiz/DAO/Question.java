package com.appland.quiz.DAO;

import java.util.List;

import javax.persistence.ElementCollection;

import com.appland.quiz.models.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
	private String text;
	private long companyId;
	private long subTopicId;
	@ElementCollection(targetClass = Long.class)
	private List<Long> tagIdList;
	private long userId;
}
