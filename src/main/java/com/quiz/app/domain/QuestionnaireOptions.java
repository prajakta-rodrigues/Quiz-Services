package com.quiz.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire_options", schema = "quiz")
public class QuestionnaireOptions {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "questionaire_id")
	private Questionnaire questionaire;
	
	@Column(name = "option_image")
	private String optionImage;

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

	public String getOptionImage() {
		return optionImage;
	}

	public void setOptionImage(String optionImage) {
		this.optionImage = optionImage;
	}
}
