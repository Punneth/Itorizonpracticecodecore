package com.Map;

import java.util.HashMap;

public class BuildInMethodsinHashMap2 {

	public static void main(String[] args) {
		HashMap<String,String> myDetails = new HashMap<String,String>();
		myDetails.put("FirstName", "Rakesh");
		myDetails.put("SurName", "Basavarajappa");
		myDetails.put("Phone Number", "875654647");
		myDetails.put("Password", "##78**");
		myDetails.put("Gender", "Male");
		
		System.out.println(myDetails);
		
		System.out.println("Number of Entrys : " + myDetails.size());
		
		System.out.println("HashMap is Empty : " + myDetails.isEmpty());
		
		System.out.println("Checking key is present : " + myDetails.containsKey("SurName"));
		
		System.out.println("Checking key is present : " + myDetails.containsKey("LastName"));
		
		System.out.println("Checking value is present : " + myDetails.containsValue("Rakesh"));
		
		System.out.println("Checking value is present : " + myDetails.containsValue("Alex"));
		
		System.out.println(myDetails.remove("SurName"));
		System.out.println(myDetails);
		
		
		
	}

}
