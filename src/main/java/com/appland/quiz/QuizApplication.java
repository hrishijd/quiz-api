package com.appland.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appland.quiz.DAO.Question;
import com.appland.quiz.services.QuestionService;

@SpringBootApplication
public class QuizApplication {
	QuestionService qs=new QuestionService();

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

}
