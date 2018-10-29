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
import com.marketlogic.surveyapp.repository.SurveyRepository;
import com.marketlogic.surveyapp.service.SurveyService;
import com.marketlogic.surveyapp.service.SurveyServiceImpl;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SurveyServiceImpl.class)
@SpringBootTest
@SpringBootConfiguration
public class SurveyServiceImplTest {

	@MockBean
	private SurveyRepository surveyRepo;
	
	@Autowired
	private SurveyService service;
	
	 private Survey survey= new Survey();
	 
	 private Question question= new Question();
	 
	 private Answer answer1= new Answer();
	 private Answer answer2= new Answer();
	
	@Before
	public void setup() {
		survey.setSurveyId(2);
		survey.setDescription("Test survey");
		survey.setEndDate(new Date());
		survey.setEndDate(new Date());
		Collection<Question> questionList= new ArrayList();
		questionList.add(question);
		survey.setQuestionsList(questionList);
		
		question.setQuestionId(2);
		question.setText("Which one is favorite programming language ?");
		Collection<Answer> answerList= new ArrayList();
		question.setAnswersList(answerList);
		answer1.setAnswerId(6);
		answer1.setAnswerText("C");
		answer2.setAnswerId(7);
		answer2.setAnswerText("C++");
		answerList.add(answer1);
		answerList.add(answer2);
	}
	
	@Test
	public void getSurveyByIdTest(){
		Mockito.when(surveyRepo.findOne(2)).thenReturn(survey);
		Survey expectedSurvey=service.getSurveyById(2);
		Assert.assertSame(expectedSurvey, survey);
		Assert.assertEquals(expectedSurvey.getDescription(), survey.getDescription());
		Assert.assertEquals(expectedSurvey.getSurveyId(), survey.getSurveyId());
		Assert.assertEquals(expectedSurvey.getDescription(), survey.getDescription());
		Assert.assertEquals(expectedSurvey.getQuestionsList().size(), survey.getQuestionsList().size());
	}
	
	
	@Test(expected= HttpClientErrorException.class)
	public void getSurveyByIdSurveyNotFound(){
		Mockito.when(surveyRepo.findOne(2)).thenReturn(null);
		service.getSurveyById(2);
	}
	
	@Test
	public void getAllSurveyTest(){
		List<Survey> surveyList= new ArrayList<Survey>();
		surveyList.add(survey);
		Mockito.when(surveyRepo.findAll()).thenReturn(surveyList);
		List<Survey> expectedSurveyList=service.getAllSurvey();
		Assert.assertEquals(expectedSurveyList.size(), surveyList.size());
	}
	
	@Test(expected= HttpClientErrorException.class)
	public void getAllSurveyTestNotFound(){
		Mockito.when(surveyRepo.findAll()).thenReturn(null);
		service.getAllSurvey();
	}
}