package com.marketlogic.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.marketlogic.surveyapp.model.Question;
import com.marketlogic.surveyapp.repository.QuestionRepository;
@Service(value="questionService")
public class QuestionsServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Question getQuestionById(Integer id) {
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Input format is wrong");
		}
		Question question= questionRepo.findOne(id);
		
		if (question == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No question are found for requested id" + id);
		}
		return question;
	}

	@Override
	public void createQuestion(Question question) {
		questionRepo.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questionList= questionRepo.findAll();
		
		if (questionList == null || questionList.size()==0) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No questions found");
		}
		return questionList;
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