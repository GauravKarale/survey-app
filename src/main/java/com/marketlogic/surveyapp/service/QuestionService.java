package com.marketlogic.surveyapp.service;

import java.util.List;

import com.marketlogic.surveyapp.model.Question;


public interface QuestionService {

	public Question getQuestionById(Integer id);

	public void createQuestion(Question question);

	public List<Question> getAllQuestion();

	public void deleteQuestion(int id);
	
	public void updateQuestion(Question question);
}
