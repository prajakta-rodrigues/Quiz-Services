package com.quiz.app.vo;

public class CreateQuestionnaireRequest {
  private String name;
  private String information;
  private int categoryId;
  private String thumbnail;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getInformation() {
    return information;
  }
  public void setInformation(String information) {
    this.information = information;
  }
  public String getThumbnail() {
    return thumbnail;
  }
  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
  public int getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }
  

}
