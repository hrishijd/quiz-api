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
public class AnswerDetail {
	private String text;
	private long userId;
	private long likes;
	private List<CommentDetail> commentList;
}

