package com.itoItTracker.assignment.spring.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
	
	private int userId;
	@NotEmpty
	private String name;
	
	@Email(message = "Your email is not valid",regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}")
	private String emailId;
	
	private String createDateTime;
	
	private String lastModifiedDateTime;
	
	public UserDto() {
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	public UserDto(int userId, String name, String emailId, String createDateTime, String lastModifiedDateTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.createDateTime = createDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	
}
