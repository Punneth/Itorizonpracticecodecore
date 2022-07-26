package com.Map;

import java.util.HashMap;
import java.util.Scanner;

public class BuildInMethodsInMap3 {

	public static void main(String[] args) {
		HashMap<String,String> myDetails = new HashMap<String,String>();
		myDetails.put("FirstName", "Rakesh");
		myDetails.put("SurName", "Basavarajappa");
		myDetails.put("Phone Number", "875654647");
		myDetails.put("Password", "##78**");
		myDetails.put("Gender", "Male");
		myDetails.put("DOB", "13/04/1998");
		
		System.out.println(myDetails);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the key :");
		String key = scan.next();
		System.out.println("Enter the value :");
		String value = scan.next();
		
//		if(myDetails.containsKey(key)==false) {
//			myDetails.put(key, value);
//		}
		myDetails.putIfAbsent(key, value);
		System.out.println(myDetails);
	}

}
