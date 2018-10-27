package com.marketlogic.surveyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marketlogic.surveyapp.model.Response;

public interface ResponseRepository extends JpaRepository<Response, Integer>{

	@Query(value = "SELECT * FROM RESPONSE WHERE SURVEY_ID = ?1 AND  QUESTION_ID =?2", nativeQuery = true)
	public List<Response> getResponseForSurvey(Integer surveyId,Integer questionId);
}
