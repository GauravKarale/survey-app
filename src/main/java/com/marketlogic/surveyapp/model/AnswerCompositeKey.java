package com.marketlogic.surveyapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AnswerCompositeKey implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1032951050163876596L;

	private Integer question_id;
	
	private Integer answer_id;
	
	
	public AnswerCompositeKey(){
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_id == null) ? 0 : answer_id.hashCode());
		result = prime * result + ((question_id == null) ? 0 : question_id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerCompositeKey other = (AnswerCompositeKey) obj;
		if (answer_id == null) {
			if (other.answer_id != null)
				return false;
		} else if (!answer_id.equals(other.answer_id))
			return false;
		if (question_id == null) {
			if (other.question_id != null)
				return false;
		} else if (!question_id.equals(other.question_id))
			return false;
		return true;
	}


	public Integer getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}


	public Integer getAnswer_id() {
		return answer_id;
	}


	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
}
