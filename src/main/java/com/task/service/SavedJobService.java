package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Entity.SavedJob;
import com.task.Entity.User;
import com.task.repo.Savedjobrepo;

@Service
public class SavedJobService {
	
	 @Autowired
	    private Savedjobrepo savedjobrepo;

	    public void save(SavedJob job) {
	        savedjobrepo.save(job);
	    }

	    public List<SavedJob> getSavedJobs(User user) {
	        return savedjobrepo.findByUser(user);
	    }

}
