package com.task.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Entity.SavedJob;
import com.task.Entity.User;

public interface Savedjobrepo extends JpaRepository<SavedJob,Integer> {
	
	public  List<SavedJob> findByUser(User user);

}
