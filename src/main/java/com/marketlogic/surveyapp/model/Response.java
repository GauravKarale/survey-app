package com.marketlogic.surveyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="Response")
@Table(name="response")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3485503575007913117L;

	@Id
	@Column(name="response_id")
	private Integer responseId;
	
	@Column(name="question_id")
	private Integer questionId;
	
	@Column(name="survey_id")
	private Integer surveyId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="answer_id")
	private Integer answerId; 
	
	@Transient
	@OneToOne(fetch = FetchType.EAGER)
	 @JoinColumns({
	       @JoinColumn(
	            name = "answer_id",
	            referencedColumnName = "answer_id",updatable = false, insertable = false),
	    })
	private Answer answer;
	
	@Transient
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({
	        @JoinColumn(
	            name = "question_id",
	            referencedColumnName = "question_id",updatable = false, insertable = false)
	})
	private Question question;
	
	public Response(){
	}

	public Answer getAnswer() {
		return answer;
	}

	


	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Question getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", questionId=" + questionId + ", surveyId=" + surveyId
				+ ", userId=" + userId + ", answerId=" + answerId + "]";
	}
	
	
}