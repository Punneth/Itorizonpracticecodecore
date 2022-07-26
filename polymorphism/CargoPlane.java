package javabasics;

import com.polymorphism.Plane;

public class CargoPlane extends Plane {
	public void land()
	{
		System.out.println("CargoPlane needs more run way to land");
	}
	public void takeOff()
	{
		System.out.println("CargoPlane needs long run way to taking off");
	}

}
