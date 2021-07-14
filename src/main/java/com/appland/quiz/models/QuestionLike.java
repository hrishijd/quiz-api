package com.appland.quiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questionLikeId;
	private long userId;
	private long questionId;
}
