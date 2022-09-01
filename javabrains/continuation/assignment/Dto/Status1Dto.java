package com.youtube.javabrains.continuation.assignment.Dto;

import com.youtube.javabrains.continuation.assignment.entity.Ticket1;

public class Status1Dto {
	
	private Integer statusId1;
	private String status1;
	
	private Ticket1 ticket1;

	public Status1Dto() {
		super();
	}

	public Status1Dto(Integer statusId1, String status1, Ticket1 ticket1) {
		super();
		this.statusId1 = statusId1;
		this.status1 = status1;
		this.ticket1 = ticket1;
	}

	public Integer getStatusId1() {
		return statusId1;
	}

	public void setStatusId1(Integer statusId1) {
		this.statusId1 = statusId1;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public Ticket1 getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}
	
	


}
