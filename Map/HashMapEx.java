package com.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String,String>();
		System.out.println(hm);
		hm.put("FirstName", "Puneeth");
		hm.put("SurName", "S B");
		hm.put("PhoneNumber", "95875665656");
		hm.put("Password", "#756h");
		System.out.println(hm);
		
		/*
		 * System.out.println(hm.get("FirstName"));
		 * System.out.println(hm.get("PhoneNumber"));
		 */
		
		Collection<String> values = hm.values();
		System.out.println(values);
		for(Object obj : values) {
			System.out.println(obj);
		}
		
		Set<String> keys = hm.keySet();
		System.out.println(keys);
		for(String key : keys) {
			System.out.println(key);
		}
		
		for(String key : keys) {
			System.out.println(key + " : " + hm.get(key));
		}
	}

}
