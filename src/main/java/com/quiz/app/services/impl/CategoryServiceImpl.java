package com.quiz.app.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.app.domain.Category;
import com.quiz.app.enums.Status;
import com.quiz.app.repositories.CategoryRepository;
import com.quiz.app.services.CategoryService;
import com.quiz.app.vo.CategoryAddRequest;
import com.quiz.app.vo.GenericResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public List<Category> viewAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public GenericResponse addCategory(CategoryAddRequest categoryAddRequest) {
    Category category = null;
    category = new Category();
    category.setDescription(categoryAddRequest.getDescription());
    category.setTitle(categoryAddRequest.getName());
    categoryRepository.save(category);
    return new GenericResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getDescription());
  }

}
