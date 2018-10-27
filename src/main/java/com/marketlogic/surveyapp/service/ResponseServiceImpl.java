package com.marketlogic.surveyapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.marketlogic.surveyapp.model.Response;
import com.marketlogic.surveyapp.model.ResponseStatics;
import com.marketlogic.surveyapp.repository.ResponseRepository;

@Service(value = "responseService")
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	private ResponseRepository repository;

	@Autowired
	@Qualifier(value = "surveyService")
	private SurveyService surveyService;

	@Autowired
	@Qualifier("questionService")
	QuestionService questionService;

	@Override
	public Response getResponse(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public void createResponse(Response response) {
		repository.save(response);
	}

	@Override
	public void deleteResponse(Integer id) {
		repository.delete(id);
	}

	@Override
	public void updateResponse(Response response) {
		repository.save(response);
	}

	@Override
	public ResponseStatics getSurveyStats(Integer surveyId, Integer questionId) {
		List<Response> responseList = repository.getResponseForSurvey(surveyId, questionId);
		int totalCount = responseList.size();
		Map<String, String> statsMap = new HashMap<String, String>();

		Map<Object, List<Response>> collect = responseList.stream()
				.collect(Collectors.groupingBy(o -> o.getAnswer().getAnswerText()));
		collect.entrySet().forEach(e -> statsMap.put(e.getKey().toString(),
				(Double.valueOf((e.getValue().size() * 100) / totalCount) + "%")));
		return new ResponseStatics(responseList.get(0).getQuestion().getText(), totalCount, statsMap);
	}
}