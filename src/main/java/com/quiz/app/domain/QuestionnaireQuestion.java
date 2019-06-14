package com.quiz.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire_questions", schema = "quiz")
public class QuestionnaireQuestion {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "questionaire_id")
	private Questionnaire questionaire;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questionnaire getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(Questionnaire questionaire) {
		this.questionaire = questionaire;
	}

	public int getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(int questionDescription) {
		this.questionDescription = questionDescription;
	}

	@Column(name = "question_description")
	private int	questionDescription;
	
}
