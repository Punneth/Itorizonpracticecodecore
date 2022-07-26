package com.Map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class BuildInMethodsinHashMap {

	public static void main(String[] args) {
		HashMap<String , String> mp = new HashMap<String , String>();
		mp.put("FirstName", "Puneeth");
		mp.put("LastName", "S B");
		mp.put("PhoneNumber", "8576589486");
		mp.put("Gender", "Male");
		mp.put("State", "Karnataka");
		
		Set<Entry<String, String>> entrys = mp.entrySet();
		
		System.out.println(entrys);
		
		for(Entry entry : entrys) {
			System.out.println(entry);
		}
		
		for(Entry entry : entrys) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
