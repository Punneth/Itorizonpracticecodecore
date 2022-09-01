package com.itoItTracker.assignment.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priority")
public class Priority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priorityId;
	private String priority;
	
	public Priority() {
		super();
	}

	public Priority(int priorityId, String priority) {
		super();
		this.priorityId = priorityId;
		this.priority = priority;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
