package com.youtube.javabrains.continuation.assignment.Dto;

public class AdminTeam1Dto {
	
	private int adminId1;
	private String name1;
	private String emailId1;
	
	public AdminTeam1Dto() {
		super();
	}

	public AdminTeam1Dto(int adminId1, String name1, String emailId1) {
		super();
		this.adminId1 = adminId1;
		this.name1 = name1;
		this.emailId1 = emailId1;
	}

	public int getAdminId1() {
		return adminId1;
	}

	public void setAdminId1(int adminId1) {
		this.adminId1 = adminId1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getEmailId1() {
		return emailId1;
	}

	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	

}
