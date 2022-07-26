package com.Map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx {

	public static void main(String[] args) {
		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("21.00", "indigo");
		tm.put("23.30", "goair");
		tm.put("04.30", "spicejet");
		tm.put("16.00", "vistara");
		tm.put("21.30", "airindia");
		tm.put("09.00", "indigo");
		tm.put("11.00", "spicejet");
		tm.put("13.00", "goair");
		
		Set<Entry<String, String>> entrys = tm.entrySet();
		for(Entry<String, String> entry : entrys) {
			System.out.println(entry);
		}
		
		System.out.println();
		System.out.println(tm.firstKey());
		System.out.println();
		System.out.println(tm.firstEntry());
		System.out.println();
		System.out.println(tm.lastKey());
		System.out.println();
		System.out.println(tm.lastEntry());

		
	}

}
