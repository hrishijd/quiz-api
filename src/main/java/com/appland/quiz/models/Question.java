package com.appland.quiz.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questionId;
	private String text;
	@ElementCollection(targetClass = Long.class)
	private List<Long> subTopicId;
	@ElementCollection(targetClass = Long.class)
	private List<Long> tagId;
	
}
