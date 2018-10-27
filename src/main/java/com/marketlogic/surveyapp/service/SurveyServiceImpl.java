package com.marketlogic.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.marketlogic.surveyapp.model.Survey;
import com.marketlogic.surveyapp.repository.SurveyRepository;

@Service(value="surveyService")
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	private SurveyRepository surveyRepo;
	
	
	
	@Override
	public Survey getSurveyById(Integer id){
		Survey survey=surveyRepo.findOne(id);
		return survey;
	}
	
	@Override
	public void createSurvey(Survey survey) {
		surveyRepo.save(survey);
	}

	@Override
	public List<Survey> getAllSurvey() {
		return surveyRepo.findAll();
	}

	@Override
	public void deleteSurvey(int id) {
		 surveyRepo.delete(id);
	}

	@Override
	public void updateSurvey(Survey survey) {
		surveyRepo.save(survey);
	}
}
