package com.marketlogic.surveyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketlogic.surveyapp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
