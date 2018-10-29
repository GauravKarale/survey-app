package com.marketlogic.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.marketlogic.surveyapp.model.Answer;
import com.marketlogic.surveyapp.repository.AnswerRepository;
@Service(value="answerService")
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerRepository repo;
	

	@Override
	public Answer getAnswerById(Integer id) {
		if (id == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Input format is wrong");
		}
		Answer answer=repo.findOne(id);
		if (answer == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No answer are found for requested id" + id);
		}
		return null;
	}

	@Override
	public void createAnswer(Answer answer) {
		if (answer == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "POST request is not well formatted");
		}
		repo.save(answer);
	}

	@Override
	public List<Answer> getAllAnswer() {
		List<Answer> answerList = repo.findAll();
		if (answerList == null || answerList.size()==0) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "No asnwer found");
		}
		return answerList;
	}

	@Override
	public void deleteAnswer(int id) {
		repo.delete(id);
	}

	@Override
	public void updateAnswer(Answer answer) {
		if (answer == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "POST request is not well formatted");
		}
		repo.save(answer);
	}
}
