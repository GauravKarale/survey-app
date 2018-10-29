package com.marketlogic.surveyapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="survey")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Survey implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3787226859280160766L;
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer surveyId;
	
	
	@Column(name="start_date")
	private Date startDate;
	
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="survey_questions",joinColumns=@JoinColumn(name="survey_id"),
	inverseJoinColumns=@JoinColumn(name="question_id"))
	private Collection<Question> questionsList= new ArrayList<Question>();
	
	public Survey(){
	}

	public Survey(Integer surveyId, Date startDate, Date endDate, String description) {
		super();
		this.surveyId = surveyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(Collection<Question> questionsList) {
		this.questionsList = questionsList;
	}
}