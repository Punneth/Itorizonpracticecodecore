package com.collection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ArraydequeEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque ad = new ArrayDeque();
		ad.add(900);
		for (int i = 10; i <15; i++) {
			ad.add(i*1);
		}
				
		ad.add(756);
		System.out.println(ad);
		for (Object ele:ad) {
			System.out.println(ele);
		}

	}

}
