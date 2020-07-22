package com.quiz.app.vo;

import java.util.List;

public class CreateQuestionRequest {
  private long questionnaireId;
  private String questionDescription;
  private List<Option> questionOptions;
  
  public long getQuestionnaireId() {
    return questionnaireId;
  }
  public void setQuestionnaireId(long questionnaireId) {
    this.questionnaireId = questionnaireId;
  }
  public String getQuestionDescription() {
    return questionDescription;
  }
  public void setQuestionDescription(String questionDescription) {
    this.questionDescription = questionDescription;
  }
  public List<Option> getQuestionOptions() {
    return questionOptions;
  }
  public void setQuestionOptions(List<Option> questionOptions) {
    this.questionOptions = questionOptions;
  }
  
  
}
