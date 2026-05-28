package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Entity.ApplyJob;
import com.task.repo.ApplyJobRepo;


@Service
public class ApplyJobService {
	
	@Autowired
	private ApplyJobRepo applyjobrepo;
	
	 public void apply(ApplyJob applyJob) {

	        applyjobrepo.save(applyJob);
	    }

}
