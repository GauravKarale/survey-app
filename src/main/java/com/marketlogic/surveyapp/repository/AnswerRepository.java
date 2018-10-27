package com.marketlogic.surveyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketlogic.surveyapp.model.Answer;
import com.marketlogic.surveyapp.model.AnswerCompositeKey;

public interface AnswerRepository extends JpaRepository<Answer, AnswerCompositeKey>{

}
