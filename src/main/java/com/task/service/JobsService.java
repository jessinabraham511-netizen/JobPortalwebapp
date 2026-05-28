package com.task.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Entity.Jobs;
import com.task.repo.JobsRepo;



@Service
public class JobsService {
	
	@Autowired
	private JobsRepo jobsrepo;
	
	public void savejob(Jobs jobs) {
		jobsrepo.save(jobs);
	}
	
	public List<Jobs> getAllJobs() {
		List<Jobs> l = jobsrepo.findAll();
		return l;
	}
	
	public Jobs getJobById(int id) {
		
		return jobsrepo.findById(id).orElse(null);
	}
	
	
}
