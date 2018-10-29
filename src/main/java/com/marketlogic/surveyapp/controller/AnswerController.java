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

import com.marketlogic.surveyapp.model.Answer;
import com.marketlogic.surveyapp.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	@Qualifier("answerService")
	private AnswerService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Answer getAnswer(@PathVariable int id) {
		return service.getAnswerById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Answer> getAnswer() {
		return service.getAllAnswer();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createAnswer(@RequestBody Answer answer) {
		service.createAnswer(answer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteAnswer(@PathVariable int id) {
		service.deleteAnswer(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateAnswer(@RequestBody Answer answer) {
		service.updateAnswer(answer);
	}
}
