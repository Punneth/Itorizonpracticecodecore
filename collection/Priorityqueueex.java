package com.collection;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Priorityqueueex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PriorityQueue<String> pq = new PriorityQueue();
		pq.add("Punee");
		pq.add("68.5");
		System.out.println(pq);
		for(Object obj:pq) {
			System.out.println(obj);
		}
	}

}
