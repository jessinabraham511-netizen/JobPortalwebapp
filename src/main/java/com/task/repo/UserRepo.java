package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	
	public User findByEmail(String email);

}
