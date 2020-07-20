package com.quiz.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.app.domain.Category;
import com.quiz.app.services.CategoryService;
import com.quiz.app.vo.CategoryAddRequest;
import com.quiz.app.vo.GenericResponse;

@RestController
public class CategoryController {
  
  @Autowired
  CategoryService categoryService; 
  
  @RequestMapping(value = "/viewAllCategories", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<List<Category>> viewAllCategories() {
    try {
      return new ResponseEntity<>(categoryService.viewAllCategories(), HttpStatus.OK);
    }
    catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } 
  }
  
  @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<GenericResponse> addCategory(@RequestBody CategoryAddRequest categoryAddRequest) {
    try {
      return new ResponseEntity<>(categoryService.addCategory(categoryAddRequest), HttpStatus.OK);
    }
    catch(Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } 
  }
  

}
