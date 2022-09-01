package com.youtube.javabrains.continuation.assignment.Dto;

import com.youtube.javabrains.continuation.assignment.entity.Ticket1;

public class Priority1Dto {
	
	private int priorityId1;
	private String priority1;
	
	private Ticket1 ticket1;

	public Priority1Dto() {
		super();
	}

	public Priority1Dto(int priorityId1, String priority1, Ticket1 ticket1) {
		super();
		this.priorityId1 = priorityId1;
		this.priority1 = priority1;
		this.ticket1 = ticket1;
	}

	public int getPriorityId1() {
		return priorityId1;
	}

	public void setPriorityId1(int priorityId1) {
		this.priorityId1 = priorityId1;
	}

	public String getPriority1() {
		return priority1;
	}

	public void setPriority1(String priority1) {
		this.priority1 = priority1;
	}

	public Ticket1 getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}
	
	

}
