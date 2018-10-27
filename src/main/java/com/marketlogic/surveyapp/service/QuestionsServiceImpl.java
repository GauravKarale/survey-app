package com.marketlogic.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.surveyapp.model.Question;
import com.marketlogic.surveyapp.repository.QuestionRepository;
@Service(value="questionService")
public class QuestionsServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Question getQuestionById(Integer id) {
		return questionRepo.findOne(id);
	}

	@Override
	public void createQuestion(Question question) {
		questionRepo.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}

	@Override
	public void deleteQuestion(int id) {
		questionRepo.delete(id);
	}

	@Override
	public void updateQuestion(Question question) {
		questionRepo.save(question);
	}

}
