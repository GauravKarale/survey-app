package com.marketlogic.surveyapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="Questions")
@Table(name="questions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611054362727708211L;
	
	@Id
	@Column(name="question_id")
	private Integer questionId;
	
	@Column(name="text")
	private String text;
	
	@OneToMany(fetch = FetchType.EAGER)
	 @JoinColumns({
	        @JoinColumn(
	            name = "question_id",
	            referencedColumnName = "question_id",updatable = true, insertable = true),
	    })
	private Collection<Answer> answerList= new ArrayList<Answer>();
	
	public Collection<Answer> getAnswerList() {
		return answerList;
	}

	/*public void setAnswersList(Collection<Answer> answerList) {
		this.answerList = answerList;
	}*/

	public Question(){
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
