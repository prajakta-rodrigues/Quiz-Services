package com.quiz.app.vo;

public class Option {
  private String optionImage;
  private String text;
  private boolean isAnswer;
  
  public String getOptionImage() {
    return optionImage;
  }
  public void setOptionImage(String optionImage) {
    this.optionImage = optionImage;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public boolean getIsAnswer() {
    return isAnswer;
  }
  public void setIsAnswer(boolean isAnswer) {
    this.isAnswer = isAnswer;
  }
}
