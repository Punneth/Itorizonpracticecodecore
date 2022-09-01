package com.youtube.javabrains.continuation.assignment.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "category1")
public class Category1 {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int categoryId1;
		private String categoryDesc1;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Ticket1 ticket1;
		
		@OneToMany(mappedBy = "category1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<SubCategory1> subCategory1;

		public Category1() {
			super();
		}

		public Category1(int categoryId1, String categoryDesc1, Ticket1 ticket1, List<SubCategory1> subCategory1) {
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
