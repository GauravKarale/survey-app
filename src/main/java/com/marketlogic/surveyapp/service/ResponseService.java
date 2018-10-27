package com.marketlogic.surveyapp.service;

import java.util.Map;

import com.marketlogic.surveyapp.model.Response;
import com.marketlogic.surveyapp.model.ResponseStatics;

public interface ResponseService{

	public Response getResponse(Integer id);
	
	public void createResponse(Response response);
	
	public void deleteResponse(Integer id);
	
	public void updateResponse(Response response);
	
	public ResponseStatics getSurveyStats(Integer surveyId, Integer questionId);
	
}
