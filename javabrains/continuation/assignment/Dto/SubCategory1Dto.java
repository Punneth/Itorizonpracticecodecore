package com.youtube.javabrains.continuation.assignment.Dto;

import com.youtube.javabrains.continuation.assignment.entity.Category1;
import com.youtube.javabrains.continuation.assignment.entity.Ticket1;

public class SubCategory1Dto {
	
	private int subCategoryId1;	
	private String subCategoryDesc1;
	
	
	private Ticket1 ticket1;
	private Category1 category1;


	public SubCategory1Dto() {
		super();
	}

	public SubCategory1Dto(int subCategoryId1, String subCategoryDesc1, Ticket1 ticket1, Category1 category1) {
		super();
		this.subCategoryId1 = subCategoryId1;
		this.subCategoryDesc1 = subCategoryDesc1;
		this.ticket1 = ticket1;
		this.category1 = category1;
	}


	public int getSubCategoryId1() {
		return subCategoryId1;
	}

	public void setSubCategoryId1(int subCategoryId1) {
		this.subCategoryId1 = subCategoryId1;
	}

	public String getSubCategoryDesc1() {
		return subCategoryDesc1;
	}

	public void setSubCategoryDesc1(String subCategoryDesc1) {
		this.subCategoryDesc1 = subCategoryDesc1;
	}

	public Ticket1 getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}

	public Category1 getCategory1() {
		return category1;
	}

	public void setCategory1(Category1 category1) {
		this.category1 = category1;
	}

}
