package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertOperation {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "puni@1999";
		Statement stmt = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully loaded");
			
			con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection Successfully Established");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,0);
			String query1 = "insert into emp (`id`,`name`,`desig`,`salary`) values (08,'Rob','SME',800000)";
			String query2 = "insert into emp (`id`,`name`,`desig`,`salary`) values (09,'Rob','SME',800000)";
			String query3 = "insert into emp (`id`,`name`,`desig`,`salary`) values (10,'Rob','SME',800000)";
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			stmt.executeBatch();
			System.out.println("Query Executed Successfully");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Successfully loaded");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection not Successfully Established");
			e.printStackTrace();
		}
		try {
			con.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
