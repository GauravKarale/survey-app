package com.marketlogic.surveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.marketlogic.surveyapp.repository")
@EntityScan("com.marketlogic.surveyapp.model")
@ComponentScan("com.marketlogic.surveyapp.service")
@ComponentScan("com.marketlogic.surveyapp.exception")
@ComponentScan("com.marketlogic.surveyapp.controller")
@ComponentScan("com.marketlogic.surveyapp.config")
public class SurveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}
}
