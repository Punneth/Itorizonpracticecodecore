package com.youtube.javabrains.continuation.assignment.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket1")
public class Ticket1 {
			
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ticketId1;
		private Integer assigneeId1;
		private String subject1;
		private String description1;
		private Date createDateTime1;
		private Date lastModifiedDateTime1;
		private Integer reportedId1;
		
		
		@OneToMany(mappedBy = "ticket1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Category1> categories1;

		@OneToMany(mappedBy = "ticket1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<SubCategory1> subCategory1;
		
		@OneToOne(mappedBy = "ticket1")
		private Status1 status1;
		
		@OneToOne(mappedBy = "ticket1")
		private Priority1 priority1;
		
		@OneToMany(mappedBy = "ticket1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Comments1> comments1;

		@OneToOne(mappedBy = "ticket1")
		private User1 user1;

		
		
		public Ticket1() {
			super();
		}



		public Ticket1(int ticketId1, Integer assigneeId1, String subject1, String description1, Date createDateTime1,
				Date lastModifiedDateTime1, Integer reportedId1, List<Category1> categories1,
				List<SubCategory1> subCategory1, Status1 status1, Priority1 priority1, List<Comments1> comments1,
				User1 user1) {
			super();
			this.ticketId1 = ticketId1;
			this.assigneeId1 = assigneeId1;
			this.subject1 = subject1;
			this.description1 = description1;
			this.createDateTime1 = createDateTime1;
			this.lastModifiedDateTime1 = lastModifiedDateTime1;
			this.reportedId1 = reportedId1;
			this.categories1 = categories1;
			this.subCategory1 = subCategory1;
			this.status1 = status1;
			this.priority1 = priority1;
			this.comments1 = comments1;
			this.user1 = user1;
		}



		public int getTicketId1() {
			return ticketId1;
		}



		public void setTicketId1(int ticketId1) {
			this.ticketId1 = ticketId1;
		}



		public Integer getAssigneeId1() {
			return assigneeId1;
		}



		public void setAssigneeId1(Integer assigneeId1) {
			this.assigneeId1 = assigneeId1;
		}



		public String getSubject1() {
			return subject1;
		}



		public void setSubject1(String subject1) {
			this.subject1 = subject1;
		}



		public String getDescription1() {
			return description1;
		}



		public void setDescription1(String description1) {
			this.description1 = description1;
		}



		public Date getCreateDateTime1() {
			return createDateTime1;
		}



		public void setCreateDateTime1(Date createDateTime1) {
			this.createDateTime1 = createDateTime1;
		}



		public Date getLastModifiedDateTime1() {
			return lastModifiedDateTime1;
		}



		public void setLastModifiedDateTime1(Date lastModifiedDateTime1) {
			this.lastModifiedDateTime1 = lastModifiedDateTime1;
		}



		public Integer getReportedId1() {
			return reportedId1;
		}



		public void setReportedId1(Integer reportedId1) {
			this.reportedId1 = reportedId1;
		}



		public List<Category1> getCategories1() {
			return categories1;
		}



		public void setCategories1(List<Category1> categories1) {
			this.categories1 = categories1;
		}



		public List<SubCategory1> getSubCategory1() {
			return subCategory1;
		}



		public void setSubCategory1(List<SubCategory1> subCategory1) {
			this.subCategory1 = subCategory1;
		}



		public Status1 getStatus1() {
			return status1;
		}



		public void setStatus1(Status1 status1) {
			this.status1 = status1;
		}



		public Priority1 getPriority1() {
			return priority1;
		}



		public void setPriority1(Priority1 priority1) {
			this.priority1 = priority1;
		}



		public List<Comments1> getComments1() {
			return comments1;
		}



		public void setComments1(List<Comments1> comments1) {
			this.comments1 = comments1;
		}



		public User1 getUser1() {
			return user1;
		}



		public void setUser1(User1 user1) {
			this.user1 = user1;
		}

		
		
}
