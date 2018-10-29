package com.marketlogic.surveyapp.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.marketlogic.surveyapp.model.Answer;
import com.marketlogic.surveyapp.repository.AnswerRepository;
import com.marketlogic.surveyapp.service.AnswerService;
import com.marketlogic.surveyapp.service.AnswerServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnswerServiceImpl.class)
@SpringBootTest
@SpringBootConfiguration
public class AnswerServiceImplTest {

	
	@MockBean
	private AnswerRepository answerRepo;

	@Autowired
	@Qualifier(value="answerService")
	private AnswerService service;

	private Answer answer1 = new Answer();
	private Answer answer2 = new Answer();
	
	@Before
	public void setup() {
	
		answer1.setAnswerId(6);
		answer1.setAnswerText("C");
		answer2.setAnswerId(7);
		answer2.setAnswerText("C++");
	}
	

	@Test(expected = HttpClientErrorException.class)
	public void getAnswerByIdAnswerNotFound() {
		Mockito.when(answerRepo.findOne(5)).thenReturn(null);
		service.getAnswerById(5);
	}

	@Test
	public void getAllAnswerTest() {
		List<Answer> answerList = new ArrayList<Answer>();
		answerList.add(answer1);
		Mockito.when(answerRepo.findAll()).thenReturn(answerList);
		List<Answer> expectedAnswerList = service.getAllAnswer();
		Assert.assertEquals(expectedAnswerList.size(), answerList.size());
	}

	@Test(expected = HttpClientErrorException.class)
	public void getAllAnswerTestNotFound() {
		Mockito.when(answerRepo.findAll()).thenReturn(null);
		service.getAllAnswer();
	}
}
