package com.youtube.javabrains.continuation.assignment.Dto;

import java.util.List;

import com.youtube.javabrains.continuation.assignment.entity.SubCategory1;
import com.youtube.javabrains.continuation.assignment.entity.Ticket1;

public class Category1Repo {
	
	private int categoryId1;
	private String categoryDesc1;
	
	private Ticket1 ticket1;
	private List<SubCategory1> subCategory1;
	
	public Category1Repo() {
		super();
	}

	public Category1Repo(int categoryId1, String categoryDesc1, Ticket1 ticket1, List<SubCategory1> subCategory1) {
		super();
		this.categoryId1 = categoryId1;
		this.categoryDesc1 = categoryDesc1;
		this.ticket1 = ticket1;
		this.subCategory1 = subCategory1;
	}

	public int getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(int categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public String getCategoryDesc1() {
		return categoryDesc1;
	}

	public void setCategoryDesc1(String categoryDesc1) {
		this.categoryDesc1 = categoryDesc1;
	}

	public Ticket1 getTicket1() {
		return ticket1;
	}

	public void setTicket1(Ticket1 ticket1) {
		this.ticket1 = ticket1;
	}

	public List<SubCategory1> getSubCategory1() {
		return subCategory1;
	}

	public void setSubCategory1(List<SubCategory1> subCategory1) {
		this.subCategory1 = subCategory1;
	}
	
	

}
