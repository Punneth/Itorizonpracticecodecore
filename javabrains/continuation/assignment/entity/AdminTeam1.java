package com.youtube.javabrains.continuation.assignment.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_team1")

public class AdminTeam1 {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int adminId1;
		
		@Column(name = "admin_name1")
		private String name1;
		
		@Column(name = "admin_emailId1")
		private String emailId1;

		public AdminTeam1() {
			super();
		}

		public AdminTeam1(int adminId1, String name1, String emailId1) {
			super();
			this.adminId1 = adminId1;
			this.name1 = name1;
			this.emailId1 = emailId1;
		}

		public int getAdminId1() {
			return adminId1;
		}

		public void setAdminId1(int adminId1) {
			this.adminId1 = adminId1;
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

}
