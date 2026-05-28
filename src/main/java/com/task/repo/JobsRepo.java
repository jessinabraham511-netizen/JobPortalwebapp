package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Entity.Jobs;

public interface JobsRepo extends JpaRepository<Jobs,Integer> {

	
	
}
