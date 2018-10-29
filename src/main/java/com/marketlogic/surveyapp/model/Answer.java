package com.marketlogic.surveyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Answer")
@Table(name = "answer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5795825348267655634L;

	@Id
	@Column(name = "answer_id")
	private Integer answerId;

	@Column(name = "answer_text")
	private String answerText;

	public Answer() {
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
}
