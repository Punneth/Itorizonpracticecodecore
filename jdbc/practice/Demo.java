package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String un = "root";
		String pw = "puni@1999";
		Connection con = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully loaded");
			
			con = DriverManager.getConnection(url, un, pw);
			System.out.println("Connection Successfully Established");
			
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 0);
			 String query = "select * from emp";
			 set = stmt.executeQuery(query);
			 
			 ResultSetMetaData metaData = set.getMetaData();
			 for(int i=1; i<=metaData.getColumnCount();i++) {
				 System.out.println(metaData.getColumnClassName(i)+ " " + metaData.getColumnTypeName(i));
			 }
			 while(set.next()) {
				 System.out.println(set.getInt(1)+" "+ set.getString(2)+" "+set.getString(3)+" "+set.getInt(4)); 
			 }
			 
			 set.absolute(2);
			 System.out.println(set.getInt(1)+" "+ set.getString(2)+" "+set.getString(3)+" "+set.getInt(4));
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver not Successfully loaded");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("Connection not Successfully Established");
			e.printStackTrace();
		}
		try {
			set.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
