package com.marketlogic.surveyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketlogic.surveyapp.model.Survey;
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer>{

}
