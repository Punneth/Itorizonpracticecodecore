package com.polymorphism;

import javabasics.CargoPlane;
import javabasics.PassengerPlane;

public class AchievePolymorphism {

	public static void main(String[] args) {
		CargoPlane cp = new CargoPlane();
		PassengerPlane pp = new PassengerPlane();
		Airport a = new Airport();
		a.permit(pp);
		a.permit(cp);

		
	}

}
