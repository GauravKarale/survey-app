package com.marketlogic.surveyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.surveyapp.model.Survey;
import com.marketlogic.surveyapp.service.SurveyService;

@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	@Qualifier(value="surveyService")
	private SurveyService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Survey getSurvey(@PathVariable int id){
		return service.getSurveyById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Survey> getSurveys(){
		return service.getAllSurvey();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createSurvey(@RequestBody Survey survey){
		service.createSurvey(survey);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSurvey(@PathVariable int id){
		service.deleteSurvey(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateSurvey(@RequestBody Survey survey){
		service.createSurvey(survey);
	}
}
