package com.marketlogic.surveyapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="response_id")
	private Integer response_id;
	
	@Column(name="question_id")
	private Integer questionId;
	
	@Column(name="survey_id")
	private Integer surveyId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="answer_id")
	private Integer answer_id; 
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinColumns({
	        @JoinColumn(
	            name = "question_id",
	            referencedColumnName = "question_id",updatable = false, insertable = false)
	    ,@JoinColumn(
	            name = "answer_id",
	            referencedColumnName = "answer_id",updatable = false, insertable = false),
	    })
	private Answer answer;
	
	
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

	public Integer getResponse_id() {
		return response_id;
	}

	public void setResponse_id(Integer response_id) {
		this.response_id = response_id;
	}

	public Integer getQuestionId() {
		return questionId;
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

	public Integer getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}

	public Question getQuestion() {
		return question;
	}
}