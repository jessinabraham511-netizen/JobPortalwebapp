package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Entity.User;
import com.task.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo=null;
	
	public User register(User user) {
		
		User s = userrepo.save(user);
		return s;
		
	}
	
	public User login(String email, String password) {
		
		User s1 = userrepo.findByEmail(email);
		
		if(s1!=null && s1.getPassword().equals(password)) {
			return s1;
		}
        return null;		
	}
	public User getByEmail(String email) {
	    return userrepo.findByEmail(email);
	}
	

}
