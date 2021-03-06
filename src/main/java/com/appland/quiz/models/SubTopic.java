package com.appland.quiz.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subTopicId;
	private String name;
	private long topicId;
	@ElementCollection(targetClass = Long.class)
	private List<Long> questionIdList;
}
