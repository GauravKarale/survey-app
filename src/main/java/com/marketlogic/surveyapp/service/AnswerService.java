package com.marketlogic.surveyapp.service;

import java.util.List;

import com.marketlogic.surveyapp.model.Answer;

public interface AnswerService {
	
	public Answer getAnswerById(Integer id);

	public void createAnswer(Answer answer);

	public List<Answer> getAllAnswer();

	public void deleteAnswer(int id);
	
	public void updateAnswer(Answer answer);

}
