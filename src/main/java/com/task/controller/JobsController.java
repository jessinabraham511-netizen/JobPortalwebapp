package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.Entity.ApplyJob;
import com.task.Entity.Jobs;
import com.task.Entity.SavedJob;
import com.task.Entity.User;
import com.task.service.ApplyJobService;
import com.task.service.JobsService;
import com.task.service.SavedJobService;
import com.task.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobsController {
	
	@Autowired
	private JobsService jobsservice;
	
	@Autowired
	private ApplyJobService applyjobservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SavedJobService savedjobservice;
	
	@GetMapping("/addJob")
	public String addjobpage(HttpSession session, Model model) {
		
		User user = (User) session.getAttribute("user");
		if(user== null ||!user.getRole().equals("RECRUITER")) {
			
			return "redirect:/jobs";
		}
		model.addAttribute("job",new Jobs());
		return"add-job";
		
	}
	
	@PostMapping("/saveJob")
	public String savejob(@ModelAttribute Jobs jobs, HttpSession session) {
		
		User user =(User) session.getAttribute("user");
		if(user==null || !user.getRole().equals("RECRUITER")) {
			return "redirect:/jobs";
		}
		jobsservice.savejob(jobs);
		return "redirect:/jobs";
		
	}
	
	@GetMapping("/jobs")
	public String viewjobs(Model model, HttpSession session) {
		
		User user =(User) session.getAttribute("user");
		if(user==null) {
			return "redirect:/";
		}
		List<Jobs> L1 = jobsservice.getAllJobs();
		model.addAttribute("jobs",L1);
		return "jobs";
		
	}
	
	@GetMapping("/apply")
	public String applyPage(int id, Model model, HttpSession session) {
		
		User user=(User) session.getAttribute("user");
		if(user==null || !user.getRole().equals("CANDIDATE")) {
			return "redirect:/jobs";
		}
		
		Jobs job = jobsservice.getJobById(id);
		ApplyJob applyjob=new ApplyJob();
		applyjob.setJobTitle(job.getTitle());
		applyjob.setCompany(job.getCompany());
		
		model.addAttribute("applyJob",applyjob);
		return "apply-job";
	}
	
	@PostMapping("/submit")
	public String submitapplication(@ModelAttribute ApplyJob applyjob,
	                                HttpSession session) {

	    User user = (User) session.getAttribute("user");

	    if(user == null || !user.getRole().equals("CANDIDATE")) {
	        return "redirect:/";
	    }

	    applyjob.setUser(user);
	    applyjob.setStatus("Applied");

	    applyjobservice.apply(applyjob);

	    return "redirect:/jobs";
	}
	
	@GetMapping("/appliedJobs")
	public String appliedjobs(Model model, HttpSession session) {

	    User user = (User) session.getAttribute("user");

	    if(user == null || !user.getRole().equals("CANDIDATE")) {
	        return "redirect:/";
	    }

	    User dbUser = userservice.getByEmail(user.getEmail());

	    model.addAttribute("jobs", dbUser.getAppliedJobs());

	    return "applied-jobs";
	}
	
	@GetMapping("/saveCandidateJob")
	public String saveCandiateJob(int id,HttpSession session) {
		
		User user=(User) session.getAttribute("user");
		
		if(user==null || !user.getRole().equals("CANDIDATE")) {
			
			return "redirect:/";
		}
		
		Jobs job = jobsservice.getJobById(id);
		SavedJob savedJob = new SavedJob();
		   savedJob.setJobTitle(job.getTitle());
		    savedJob.setCompany(job.getCompany());
		    savedJob.setLocation(job.getLocation());

		    savedJob.setUser(user);

		    savedjobservice.save(savedJob);

		    return "redirect:/savedJobs";
		
	}
	@GetMapping("/savedJobs")
	public String savedjobs(Model model, HttpSession session) {
		
		User user=(User) session.getAttribute("user");
		if(user==null || !user.getRole().equals("CANDIDATE")) {
			return "redirect:/";
		}
		List<SavedJob> jobs = savedjobservice.getSavedJobs(user);
		
		model.addAttribute("jobs", jobs);
		return "saved-jobs";
	}
	@GetMapping("/profile")
	public String profilePage(Model model,HttpSession session ) {
		
		User user=(User) session.getAttribute("user");
		if(user==null || !user.getRole().equals("CANDIDATE")) {
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "profile";
	}
	@PostMapping("/updateProfile")
	public String updateProfile(@ModelAttribute User updatedUser,
	                            HttpSession session) {

	   
		 User sessionUser = (User) session.getAttribute("user");
	    
		 if(sessionUser == null){
			    return "redirect:/";
			}

	    sessionUser.setBio(updatedUser.getBio());
	    sessionUser.setSkills(updatedUser.getSkills());
	    sessionUser.setCollege(updatedUser.getCollege());
	    sessionUser.setDegree(updatedUser.getDegree());
	    sessionUser.setExperience(updatedUser.getExperience());
	    sessionUser.setLinkedin(updatedUser.getLinkedin());
	    sessionUser.setGithub(updatedUser.getGithub());
	    sessionUser.setPhone(updatedUser.getPhone());
	    sessionUser.setProfilePhoto(updatedUser.getProfilePhoto());

	    
	    sessionUser.setProfileCompleted(true);

	    userservice.register(sessionUser);

	    session.setAttribute("user", sessionUser);

	    return "redirect:/profile";
	}
	@GetMapping("/editProfile")
	public String editProfile(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		if(user==null || !user.getRole().equals("CANDIDATE")) {
			return "redirect:/";
		}
		
		model.addAttribute("user", user);
		return "profile";
	}
	
	 @GetMapping("/gotohome")
	    public String home( Model model, HttpSession session) {
	        User user = (User)session.getAttribute("user");
	        if(user==null) {
	        	return "redirect:/";
	        }
	        model.addAttribute("user",user);
	        return "home";
	    }
}
