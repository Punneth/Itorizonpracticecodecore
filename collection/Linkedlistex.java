package com.collection;

import java.util.LinkedList;
import java.util.Scanner;

public class Linkedlistex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList ls = new LinkedList();
		for(int i=1;i<=10;i++) {
			int k = scan.nextInt();
			ls.add(k);	
		}
		System.out.println(ls);
		System.out.println("Using getFirst Element: " + ls.getFirst());
		System.out.println(ls);
		System.out.println("Using getLast Element: " + ls.getLast());
		System.out.println(ls);
		System.out.println("Using peekFirst method: " + ls.peekFirst());
		System.out.println(ls);
		System.out.println("Using peekLast method: " + ls.peekLast());
		System.out.println(ls);
		System.out.println("Using pollFirst method: " + ls.pollFirst());
		System.out.println(ls);
		System.out.println("Using pollLast method: " + ls.pollLast());
//		System.out.println(ls);
		for(int i=0;i<ls.size();i++) {			
			System.out.println(ls.get(i));
		}
	}

}
