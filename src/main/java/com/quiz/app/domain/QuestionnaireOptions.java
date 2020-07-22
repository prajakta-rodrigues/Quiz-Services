package com.quiz.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire_options", schema = "quiz")
public class QuestionnaireOptions {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private QuestionnaireQuestion question;
	
	public QuestionnaireQuestion getQuestion() {
    return question;
  }

  public void setQuestion(QuestionnaireQuestion question) {
    this.question = question;
  }

  @Column(name = "option_image")
	private String optionImage;
	
	@Column(name = "is_answer")
	private Boolean isAnswer;
	
	@Column(name = "text")
	private String text;

	public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getIsAnswer() {
    return isAnswer;
  }

  public void setIsAnswer(Boolean isAnswer) {
    this.isAnswer = isAnswer;
  }

  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionImage() {
		return optionImage;
	}

	public void setOptionImage(String optionImage) {
		this.optionImage = optionImage;
	}
}
