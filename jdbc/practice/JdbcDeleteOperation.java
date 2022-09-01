package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDeleteOperation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pwd = "puni@1999";
		Connection con = null;
		Statement stmt = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully loaded");
			
			con = DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection Successfully Established");
			
			String query = "delete from emp where name = 'Rob'";
			stmt = con.createStatement();
			
			
			System.out.println("Number of rows deleted" + " " + stmt.executeUpdate(query));
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
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
