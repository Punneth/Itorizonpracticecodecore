package com.collection;

import java.util.ArrayList;
import java.util.List;
public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add(10);
		a1.add(20.2);
		a1.add(true);
		a1.add("Hello");
		a1.add(2,"Puneeth");
		System.out.println(a1);
		
		ArrayList b1 = new ArrayList();
		b1.add(40);
		b1.add("Rakesh");
		b1.add(false);
		b1.add(99.9f);
		System.out.println(b1);
		
		a1.addAll(b1);
		System.out.println(a1);
		
		a1.add(2,b1);
		System.out.println(a1);
		
		System.out.println(a1.get(4));
		
		System.out.println(a1.subList(1,5));
		
		System.out.println(a1.indexOf(40));
		
		System.out.println(a1.lastIndexOf(99.9f));
		

	}

}
