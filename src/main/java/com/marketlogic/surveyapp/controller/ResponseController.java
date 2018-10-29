package com.marketlogic.surveyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.surveyapp.model.Response;
import com.marketlogic.surveyapp.model.ResponseStatics;
import com.marketlogic.surveyapp.service.ResponseService;

@RestController
@RequestMapping("/response")
public class ResponseController {

	@Autowired
	@Qualifier("responseService")
	private ResponseService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Response getResponse(@PathVariable int id) {
		return service.getResponse(id);
	}

	@RequestMapping(value = "survey/{surveyId}/question/{questionId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseStatics getSurveyStatics(@PathVariable int surveyId, @PathVariable int questionId) {
		return service.getSurveyStats(surveyId, questionId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createResponse(Response response) {
		System.out.println("response: " + response.toString());
		service.createResponse(response);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateResponse(Response response) {
		service.createResponse(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteResponse(@PathVariable int id) {
		service.deleteResponse(id);
	}
}
