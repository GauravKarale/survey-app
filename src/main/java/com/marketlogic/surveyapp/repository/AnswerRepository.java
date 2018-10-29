package com.marketlogic.surveyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketlogic.surveyapp.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
