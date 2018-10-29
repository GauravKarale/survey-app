package com.marketlogic.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.marketlogic.surveyapp.model.Survey;
import com.marketlogic.surveyapp.repository.SurveyRepository;

@Service(value = "surveyService")
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private SurveyRepository surveyRepo;

	@Override
	public Survey getSurveyById(Integer id) {
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Input format is wrong");
		}
		Survey survey = surveyRepo.findOne(id);

		if (survey == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No survey are found for requested id" + id);
		}

		return survey;
	}

	@Override
	public void createSurvey(Survey survey) {
		if (survey == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "POST request is not well formatted");
		}
		surveyRepo.save(survey);
	}

	@Override
	public List<Survey> getAllSurvey() {
		List<Survey> surveyList = surveyRepo.findAll();
		if (surveyList == null || surveyList.size()==0) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No survey found");
		}
		return surveyList;
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
