package com.marketlogic.surveyapp.service;

import java.util.List;

import com.marketlogic.surveyapp.model.Survey;

public interface SurveyService {
	public Survey getSurveyById(Integer id);

	public void createSurvey(Survey survey);

	public List<Survey> getAllSurvey();

	public void deleteSurvey(int id);
	
	public void updateSurvey(Survey survey);
}
