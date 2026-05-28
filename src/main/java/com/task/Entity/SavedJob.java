package com.task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SavedJob {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String jobTitle;
	private String company;
	private String location;
	@ManyToOne
	private User user;
	public SavedJob() {
		
		// TODO Auto-generated constructor stub
	}
	public SavedJob(Integer id, String jobTitle, String company, String location, User user) {
		super();
		Id = id;
		this.jobTitle = jobTitle;
		this.company = company;
		this.location = location;
		this.user = user;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "SavedJob [Id=" + Id + ", jobTitle=" + jobTitle + ", company=" + company + ", location=" + location
				+ ", user=" + user + "]";
	}
	
	
	

}
