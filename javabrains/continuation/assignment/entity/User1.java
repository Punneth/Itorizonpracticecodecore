package com.youtube.javabrains.continuation.assignment.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user1")
public class User1 {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private int userId1;
		
		@Column(name = "user_name1")
		private String name1;
		
		@Column(name = "user_emailId1",unique = true)
		private String emailId1;
		
		@Column(name = "user_CreateDatetime1")
		private Date createDateTime1;
		
		@Column(name ="user_LastModifieDatetime1")
		private Date lastModifiedDateTime1;
		
		
		@OneToMany(mappedBy = "user1",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Comments1> comments1;

		@OneToOne(cascade = CascadeType.ALL)
		private Ticket1 ticket1;

		public User1() {
			super();
		}

		public User1(int userId1, String name1, String emailId1, Date createDateTime1, Date lastModifiedDateTime1,
				List<Comments1> comments1, Ticket1 ticket1) {
			super();
			this.userId1 = userId1;
			this.name1 = name1;
			this.emailId1 = emailId1;
			this.createDateTime1 = createDateTime1;
			this.lastModifiedDateTime1 = lastModifiedDateTime1;
			this.comments1 = comments1;
			this.ticket1 = ticket1;
		}

		public int getUserId1() {
			return userId1;
		}

		public void setUserId1(int userId1) {
			this.userId1 = userId1;
		}

		public String getName1() {
			return name1;
		}

		public void setName1(String name1) {
			this.name1 = name1;
		}

		public String getEmailId1() {
			return emailId1;
		}

		public void setEmailId1(String emailId1) {
			this.emailId1 = emailId1;
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

		public List<Comments1> getComments1() {
			return comments1;
		}

		public void setComments1(List<Comments1> comments1) {
			this.comments1 = comments1;
		}

		public Ticket1 getTicket1() {
			return ticket1;
		}

		public void setTicket1(Ticket1 ticket1) {
			this.ticket1 = ticket1;
		}
		
}
