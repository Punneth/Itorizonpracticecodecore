package com.youtube.javabrains.continuation.assignment.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category1")
public class SubCategory1 {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int subCategoryId1;
		
		@Column(name="subCategory_des1")
		private String subCategoryDesc1;
		
		@ManyToOne(cascade = CascadeType.ALL)
		private Ticket1 ticket1;

		
		@ManyToOne(cascade = CascadeType.ALL)
		private Category1 category1;


		public SubCategory1() {
			super();
		}


		public SubCategory1(int subCategoryId1, String subCategoryDesc1, Ticket1 ticket1, Category1 category1) {
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
