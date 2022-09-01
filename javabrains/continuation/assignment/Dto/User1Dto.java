package com.youtube.javabrains.continuation.assignment.Dto;
import java.util.Date;
import java.util.List;

import com.youtube.javabrains.continuation.assignment.entity.Comments1;
import com.youtube.javabrains.continuation.assignment.entity.Ticket1;


public class User1Dto {
	
	private int userId1;
	private String name1;
	private String emailId1;
	private Date createDateTime1;
	private Date lastModifiedDateTime1;
	
	
	private List<Comments1> comments1;
	private Ticket1 ticket1;

	public User1Dto() {
		super();
	}

	public User1Dto(int userId1, String name1, String emailId1, Date createDateTime1, Date lastModifiedDateTime1,
			List<Comments1> comments1, Ticket1 ticket1) {
		super();
		this.userId1 = userId1;
		this.name1 = name1;
		this.emailId1 = emailId1;
		this.createDateTime1 = createDateTime1;
		this.lastModifiedDateTime1 = lastModifiedDateTime1;
		this.comments1 = comments1;
		this.ticket1 = ticket1;
	}

	public int getUserId1() {
		return userId1;
	}

	public void setUserId1(int userId1) {
		this.userId1 = userId1;
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

	public Date getCreateDateTime1() {
		return createDateTime1;
	}

	public void setCreateDateTime1(Date createDateTime1) {
		this.createDateTime1 = createDateTime1;
	}

	public Date getLastModifiedDateTime1() {
		return lastModifiedDateTime1;
	}

	public void setLastModifiedDateTime1(Date lastModifiedDateTime1) {
		this.lastModifiedDateTime1 = lastModifiedDateTime1;
	}

	public List<Comments1> getComments1() {
		return comments1;
	}

	public void setComments1(List<Comments1> comments1) {
		this.comments1 = comments1;
	}

	public Ticket1 getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}
}
