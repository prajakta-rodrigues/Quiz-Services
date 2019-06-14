package com.quiz.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.app.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findOne(long integer);
	
	User findByEmail(String email);
}
