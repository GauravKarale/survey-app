package com.marketlogic.surveyapp.service.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.marketlogic.surveyapp.model.Answer;
import com.marketlogic.surveyapp.model.Question;
import com.marketlogic.surveyapp.model.Survey;
import com.marketlogic.surveyapp.repository.QuestionRepository;
import com.marketlogic.surveyapp.service.QuestionService;
import com.marketlogic.surveyapp.service.QuestionsServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = QuestionsServiceImpl.class)
@SpringBootTest
@SpringBootConfiguration
public class QuestionServiceImplTest {

	@MockBean
	private QuestionRepository questionRepo;

	@Autowired
	private QuestionService service;

	private Survey survey = new Survey();

	private Question question = new Question();

	private Answer answer1 = new Answer();
	private Answer answer2 = new Answer();

	@Before
	public void setup() {
		survey.setSurveyId(2);
		survey.setDescription("Test survey");
		survey.setEndDate(new Date());
		survey.setEndDate(new Date());
		Collection<Question> questionList = new ArrayList();
		questionList.add(question);
		survey.setQuestionsList(questionList);

		question.setQuestionId(2);
		question.setText("Which one is favorite programming language ?");
		Collection<Answer> answerList = new ArrayList();
		question.setAnswersList(answerList);
		answer1.setAnswerId(6);
		answer1.setAnswerText("C");
		answer2.setAnswerId(7);
		answer2.setAnswerText("C++");
		answerList.add(answer1);
		answerList.add(answer2);
	}

	@Test
	public void getQuestionByIdTest() {
		Mockito.when(questionRepo.findOne(2)).thenReturn(question);
		Question expectedQuestion = service.getQuestionById(2);
		Assert.assertSame(expectedQuestion, question);
		Assert.assertEquals(expectedQuestion.getText(), question.getText());
		Assert.assertEquals(expectedQuestion.getQuestionId(), question.getQuestionId());
		Assert.assertEquals(expectedQuestion.getAnswerList().size(),question.getAnswerList().size());
	}

	@Test(expected = HttpClientErrorException.class)
	public void getQuestionByIdQuestionNotFound() {
		Mockito.when(questionRepo.findOne(2)).thenReturn(null);
		service.getQuestionById(2);
	}

	@Test
	public void getAllQuestionTest() {
		List<Question> questionList = new ArrayList<Question>();
		questionList.add(question);
		Mockito.when(questionRepo.findAll()).thenReturn(questionList);
		List<Question> expectedQuestionList = service.getAllQuestion();
		Assert.assertEquals(expectedQuestionList.size(), questionList.size());
	}

	@Test(expected = HttpClientErrorException.class)
	public void getAllQuestionTestNotFound() {
		Mockito.when(questionRepo.findAll()).thenReturn(null);
		service.getAllQuestion();
	}
}
