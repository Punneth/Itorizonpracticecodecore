package com.youtube.javabrains.continuation.assignment.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status1")
public class Status1 {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer statusId1;
		private String status1;
		
		@OneToOne(cascade = CascadeType.ALL)
		private Ticket1 ticket1;

		public Status1() {
			super();
		}

		public Status1(Integer statusId1, String status1, Ticket1 ticket1) {
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
