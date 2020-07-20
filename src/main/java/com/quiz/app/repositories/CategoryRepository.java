package com.quiz.app.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quiz.app.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
  
  public List<Category> findAll();

}
