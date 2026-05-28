package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.task.Entity.User;
import com.task.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String loginpage(Model model) {
		model.addAttribute("user",new User());
		
		return"login";
	}
	
	@PostMapping("/login")
	public String login(Model model,String email, String password,HttpSession session) {
		
		User user = userservice.login(email, password);
		
		if(user!=null) {
			session.setAttribute("user", user);
			return "redirect:/home";
		}
		model.addAttribute("error","Invalid Credentials");
		
		return "login";
			
	}
	
	@GetMapping("/register")
	public String registerpage(Model model) {
		model.addAttribute("user",new User());
		return "register";
		
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		userservice.register(user);
		return "redirect:/";
	}
	
	 @GetMapping("/home")
	    public String home( Model model, HttpSession session) {
	        User user = (User)session.getAttribute("user");
	        if(user==null) {
	        	return "redirect:/";
	        }
	        model.addAttribute("user",user);
	        return "home";
	    }
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
	     session.invalidate();
	     return "redirect:/";
	 }

}
