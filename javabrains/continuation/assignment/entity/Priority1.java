package com.youtube.javabrains.continuation.assignment.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "priority1")
public class Priority1 {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priorityId1;
	private String priority1;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket1 ticket1;
	
	public Priority1() {
		super();
	}

	public Priority1(int priorityId1, String priority1, Ticket1 ticket1) {
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
