package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertUsingPreparedStmt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "puni@1999";
		Connection con = null;
		PreparedStatement pstm = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully loaded");
			
			con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection Successfully Established");
			
			String query = "insert into emp (`id`,`name`,`desig`,`salary`) values (?,?,?,?)";
			pstm = con.prepareStatement(query);
			
			con.setAutoCommit(false);
			
			System.out.println("Enter the number rows to add");
			int num = scan.nextInt();
			for (int i = 1; i <= num; i++) {
				System.out.println("Enter Id");
				int id = scan.nextInt();
				
				System.out.println("Enter Name");
				String name = scan.next();
				
				System.out.println("Enter Designation");
				String desig = scan.next();
				
				System.out.println("Enter Salary");
				int salary = scan.nextInt();
				
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setString(3, desig);
				pstm.setInt(4, salary);
				pstm.execute();
			}
			con.commit();
			System.out.println("Query Executed Successfully");
			
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver not Successfully loaded");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection not Successfully Established");
			e.printStackTrace();
		}
		try {
			con.close();
			pstm.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
