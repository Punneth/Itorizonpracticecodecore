package com.youtube.javabrains.continuation.assignment.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments1")
public class Comments1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId1;
	private String message1;
	
		
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Ticket1 ticket1;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User1 user1;


	public Comments1() {
		super();
	}


	public Comments1(int commentId1, String message1, Ticket1 ticket1, User1 user1) {
		super();
		this.commentId1 = commentId1;
		this.message1 = message1;
		this.ticket1 = ticket1;
		this.user1 = user1;
	}


	public int getCommentId1() {
		return commentId1;
	}


	public void setCommentId1(int commentId1) {
		this.commentId1 = commentId1;
	}


	public String getMessage1() {
		return message1;
	}


	public void setMessage1(String message1) {
		this.message1 = message1;
	}


	public Ticket1 getTicket1() {
		return ticket1;
	}


	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}


	public User1 getUser1() {
		return user1;
	}


	public void setUser1(User1 user1) {
		this.user1 = user1;
	}


	
	

}


