package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.Entity.ApplyJob;

public interface ApplyJobRepo extends JpaRepository<ApplyJob,Integer> {

}
