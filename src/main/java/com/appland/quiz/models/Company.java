package com.appland.quiz.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Company {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
}
