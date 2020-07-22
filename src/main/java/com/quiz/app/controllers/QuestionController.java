package com.quiz.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.app.services.QuestionService;
import com.quiz.app.vo.CreateQuestionRequest;
import com.quiz.app.vo.GenericResponse;

@RestController
public class QuestionController {
  
  @Autowired
  private QuestionService questionService;
  @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
  public ResponseEntity<GenericResponse> addQuestion(@RequestBody CreateQuestionRequest createQuestionRequest) {
    try
    {
      return new ResponseEntity<>(questionService.addQuestion(createQuestionRequest), HttpStatus.OK);
    }
    catch(Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }
  }

}
