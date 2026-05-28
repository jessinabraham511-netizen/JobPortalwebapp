package com.task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ApplyJob {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String candidateName;
	private String email;
	private String phone;
	private String graduationYear;
	private String fieldOfStudy;
	private String resume;
	private String jobTitle;
	private String company;
	@ManyToOne
	private User user;
	private String status;
	
	
	public ApplyJob() {
		
		// TODO Auto-generated constructor stub
	}

	public ApplyJob(Integer id, String candidateName, String email, String phone, String graduationYear,
			String fieldOfStudy, String resume, String jobTitle, String company, User user) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.email = email;
		this.phone = phone;
		this.graduationYear = graduationYear;
		this.fieldOfStudy = fieldOfStudy;
		this.resume = resume;
		this.jobTitle = jobTitle;
		this.company = company;
		this.user = user;
		this.status=status;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getGraduationYear() {
	    return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
	    this.graduationYear = graduationYear;
	}



	public String getFieldOfStudy() {
		return fieldOfStudy;
	}



	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}



	public String getResume() {
		return resume;
	}



	public void setResume(String resume) {
		this.resume = resume;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}

	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
	    this.user = user;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}

	@Override
	public String toString() {
		return "ApplyJob [id=" + id + ", candidateName=" + candidateName + ", email=" + email + ", phone=" + phone
				+ ", graduationYear=" + graduationYear + ", fieldOfStudy=" + fieldOfStudy + ", resume=" + resume
				+ ", jobTitle=" + jobTitle + ", company=" + company + ", user=" + user + ", status=" +status+"]";
	}

	
	
	
	
	
	

}
