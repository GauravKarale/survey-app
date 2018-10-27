package com.marketlogic.surveyapp.model;

import java.util.Map;

public class ResponseStatics {
	
	private String question;
	
	private Integer totalResponseReceived;
	
	private Map<String,String> answerDistribution;
	
	public ResponseStatics(){
	}
	
	public ResponseStatics(String question, Integer totalResponseReceived, Map<String, String> map) {
		super();
		this.question = question;
		this.totalResponseReceived = totalResponseReceived;
		this.answerDistribution = map;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getTotalResponseReceived() {
		return totalResponseReceived;
	}

	public void setTotalResponseReceived(Integer totalResponseReceived) {
		this.totalResponseReceived = totalResponseReceived;
	}

	public Map<String, String> getAnswerDistribution() {
		return answerDistribution;
	}

	public void setAnswerDistribution(Map<String, String> map) {
		this.answerDistribution = map;
	}
}
