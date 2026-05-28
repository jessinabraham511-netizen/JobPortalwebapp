package com.task.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user")
	private List<ApplyJob> appliedJobs;
	private String role;
	private String profilePhoto;
	private String bio;
	private String skills;
	private String college;
	private String degree;
	private String experience;
	private String linkedin;
	private String github;
	private String phone;
	private boolean profileCompleted = false;
	public User() {
		
		// TODO Auto-generated constructor stub
	}

	
	

	



	public User(Integer id, String name, String email, String password, List<ApplyJob> appliedJobs, String role,
			String profilePhoto, String bio, String skills, String college, String degree, String experience,
			String linkedin, String github, String phone, boolean profileCompleted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.appliedJobs = appliedJobs;
		this.role = role;
		this.profilePhoto = profilePhoto;
		this.bio = bio;
		this.skills = skills;
		this.college = college;
		this.degree = degree;
		this.experience = experience;
		this.linkedin = linkedin;
		this.github = github;
		this.phone = phone;
		this.profileCompleted = profileCompleted;
	}








	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public List<ApplyJob> getAppliedJobs() {
	    return appliedJobs;
	}

	public void setAppliedJobs(List<ApplyJob> appliedJobs) {
	    this.appliedJobs = appliedJobs;
	}

	
	public String getProfilePhoto() {
		return profilePhoto;
	}




	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}




	public String getBio() {
		return bio;
	}




	public void setBio(String bio) {
		this.bio = bio;
	}




	public String getSkills() {
		return skills;
	}




	public void setSkills(String skills) {
		this.skills = skills;
	}




	public String getCollege() {
		return college;
	}




	public void setCollege(String college) {
		this.college = college;
	}




	public String getDegree() {
		return degree;
	}




	public void setDegree(String degree) {
		this.degree = degree;
	}




	public String getExperience() {
		return experience;
	}




	public void setExperience(String experience) {
		this.experience = experience;
	}




	public String getLinkedin() {
		return linkedin;
	}




	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}




	public String getGithub() {
		return github;
	}




	public void setGithub(String github) {
		this.github = github;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public boolean isProfileCompleted() {
		return profileCompleted;
	}








	public void setProfileCompleted(boolean profileCompleted) {
		this.profileCompleted = profileCompleted;
	}








	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", appliedJobs="
				+ appliedJobs + ", role=" + role + ", profilePhoto=" + profilePhoto + ", bio=" + bio + ", skills="
				+ skills + ", college=" + college + ", degree=" + degree + ", experience=" + experience + ", linkedin="
				+ linkedin + ", github=" + github + ", phone=" + phone + ", profileCompleted=" + profileCompleted + "]";
	}








	


	

	
	

}
