package com.quiz.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire_answers", schema = "quiz")
public class QuestionnaireAnswers {
	
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

	public QuestionnaireOptions getQuestionnaireOptions() {
		return questionnaireOptions;
	}

	public void setQuestionnaireOptions(QuestionnaireOptions questionnaireOptions) {
		this.questionnaireOptions = questionnaireOptions;
	}

	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "question_id")
	private Questionnaire questionaire;
	
	@OneToOne
	@JoinColumn(name = "option_id")
	private QuestionnaireOptions questionnaireOptions;

}
