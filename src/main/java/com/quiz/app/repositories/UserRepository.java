package com.quiz.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByUsername(String username);
}
