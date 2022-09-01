package com.itoItTracker.assignment.spring.Dto;

public class PriorityDto {
	
	private int priorityId;
	private String priority;
	
	public PriorityDto() {
		super();
	}

	public PriorityDto(int priorityId, String priority) {
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
