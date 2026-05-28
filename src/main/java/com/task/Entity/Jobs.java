package com.task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Jobs {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String company;
	private String location;
	private String description;
	public Jobs() {
		
		// TODO Auto-generated constructor stub
	}
	public Jobs(Integer id, String title, String company, String location, String description) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "jobs [id=" + id + ", title=" + title + ", company=" + company + ", location=" + location
				+ ", description=" + description + "]";
	}
	
	
	

}
