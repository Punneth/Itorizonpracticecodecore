package com.collection;

import java.util.LinkedList;

//Implementation of stack using LinkedList

public class StackusingLinkedList {

	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		for (int i = 1; i < 5; i++) {
			ls.push(i*10);
		}
		int s= ls.size();
		System.out.println(ls);
		for (int i = 0; i < s; i++) {
			System.out.println("popped->"+ls.pop());
		}
		System.out.println(ls);
	}

}
