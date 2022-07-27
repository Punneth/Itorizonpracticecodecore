package com.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class CompareName implements Comparator<Flight>{
	public int compare(Flight f1, Flight f2) {
		String name1 = f1.getName();
		String name2 = f2.getName();
		return name1.compareTo(name2);
	}
}

class CompareDuration implements Comparator<Flight>{
	public int compare(Flight f1, Flight f2) {
		Float duration1 = f1.getDuration();
		Float duration2 = f2.getDuration();
		return duration1.compareTo(duration2);
	}
}

class ComparePrice implements Comparator<Flight>{
	public int compare(Flight f1, Flight f2) {
		Integer price1 = f1.getPrice();
		Integer price2 = f2.getPrice();
		return price1.compareTo(price2);
	}
}


class Flight implements Comparable<Flight> {
	private String departure;
	private String name;
	private float duration;
	private  int price;
	
	public Flight() {
		
	}
	
	public Flight(String departure, String name, float duration, int price) {
		this.departure=departure;
		this.name=name;
		this.duration=duration;
		this.price=price;
	}
	public void setDeparture(String departure) {
		this.departure=departure;
	}
	public String getDeparture() {
		return departure;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDuration(float duration) {
		this.duration=duration;
	}
	public float getDuration() {
		return duration;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "[ departure=" + departure + ", name= " + name + ", duration= " + duration + ", price= " + price + " ]";
	}
	
	public int compareTo(Flight f2) {
		String s1 = this.departure;
		String s2 = f2.departure;
		return s1.compareTo(s2);
	}
		
}

public class ComparatorEx {

	public static void main(String[] args) {
		Flight f1 = new Flight("21.00", "indigo", 2.5f, 5000);
		Flight f2 = new Flight("23.30", "goair", 5.0f, 7000);
		Flight f3 = new Flight("04.30", "spicejet", 1.5f, 2500);
		Flight f4 = new Flight("16.00", "vistara", 3.5f, 6000);
		Flight f5 = new Flight("21.30", "airindia", 4.5f, 5500);
		Flight f6 = new Flight("09.00", "indigo", 4.0f, 6500);
		Flight f7 = new Flight("11.00", "spicejet", 3.7f, 9000);
		Flight f8 = new Flight("13.00", "goair", 2.0f, 8000);

		ArrayList<Flight> flightsList = new ArrayList<Flight>();
		flightsList.add(f1);
		flightsList.add(f2);
		flightsList.add(f3);
		flightsList.add(f4);
		flightsList.add(f5);
		flightsList.add(f6);
		flightsList.add(f7);
		flightsList.add(f8);
		
	
	System.out.println("Enter your choice");
	System.out.println("1. Departure");
	System.out.println("2. Name");
	System.out.println("3. Duration");
	System.out.println("4. Price");
	
	Scanner scan = new Scanner(System.in);
	int choice = scan.nextInt();
		
//		if(choice==1) {
//			Collections.sort(flightsList);
//		}
//		else if(choice == 2) {
//			Collections.sort(flightsList, new CompareName());
//		}
//		else if(choice==3) {
//			Collections.sort(flightsList, new CompareDuration());
//		}
//		else if(choice==4){
//			Collections.sort(flightsList, new ComparePrice());
//		}

		switch(choice){
		case 1 :
			Collections.sort(flightsList);
			break;
		case 2 :
    		Collections.sort(flightsList, new CompareName());
    		break;
		case 3:
  			Collections.sort(flightsList, new CompareDuration());
  			break;
		case 4:
  			Collections.sort(flightsList, new ComparePrice());
  			break;
  			default:
  				System.out.println("Enter correct number");
  				
		}
		for(Flight flight : flightsList) {
			System.out.println(flight);
		}

	}
		
//		Collections.sort(flightsList);//Default sorting
		
//		Collections.sort(flightsList, new ComparePrice());//Customised sorting
		
	
		
	}
