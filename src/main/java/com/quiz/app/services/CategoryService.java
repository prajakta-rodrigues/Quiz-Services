package com.quiz.app.services;

import java.util.List;
import com.quiz.app.domain.Category;
import com.quiz.app.vo.CategoryAddRequest;
import com.quiz.app.vo.GenericResponse;

public interface CategoryService {
  public List<Category> viewAllCategories(); 
  
  public GenericResponse addCategory(CategoryAddRequest categoryAddRequest);
}
