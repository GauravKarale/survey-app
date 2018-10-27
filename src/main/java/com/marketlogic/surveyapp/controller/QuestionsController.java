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

import com.marketlogic.surveyapp.model.Question;
import com.marketlogic.surveyapp.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	@Autowired
	@Qualifier("questionService")
	QuestionService service;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Question getQuestion(@PathVariable int id){
		return service.getQuestionById(id);
	}
	
	
	@RequestMapping(value="/{id}/answer/{answerId}",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Question getQuestion(@PathVariable int id, @PathVariable int answerId){
		return service.getQuestionById(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Question> getSurveys(){
		return service.getAllQuestion();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createQuestions(@RequestBody Question question){
		service.createQuestion(question);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteQuestion(@PathVariable int id){
		service.deleteQuestion(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateQuestions(@RequestBody Question question){
		service.updateQuestion(question);
	}
}
