package com.Map;

import java.util.HashMap;
import java.util.Set;

public class BuildInMethodsInMap4 {

	public static void main(String[] args) {
		HashMap<String,String> myDetails = new HashMap<String,String>();
		myDetails.put("FirstName", "Rakesh");
		myDetails.put("SurName", "Basavarajappa");
		myDetails.put("Phone Number", "875654647");
		myDetails.put("Password", "##78**");
		myDetails.put("Gender", "Male");
		myDetails.put("DOB", "13/04/1998");
		
		System.out.println(myDetails);
		
		HashMap<String, String> myData = new HashMap<String, String>();
		myData.put("Email", "rakeshsb@gmail.com");
		myData.put("Country", "India");
		myData.put("Blood-Groop", "B+");
		
		System.out.println(myData);
		
		/*
		  Set<String> keys = myData.keySet();
		   
		   for(String key : keys) { 
		   String value = myData.get(key);
		   myDetails.put(key,value);
		     }
		 */	
		myDetails.putAll(myData);
		System.out.println(myDetails);
		
		/*
		   myDetails.replace("Password", "abcdef"); 
		   System.out.println(myDetails);
		 */
		
		myDetails.replace("Password", "##78**", "hfgaj");
		System.out.println(myDetails);

	}

}
