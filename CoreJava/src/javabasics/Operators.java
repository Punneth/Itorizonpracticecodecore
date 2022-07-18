package javabasics;

public class Operators {

	public static void main(String[] args) {
		//Arithmatic Operators in Java.
		int i1=10;
		int i2=20;
		float f3=2.45f;
		double d4=94.857;
		String h1="Hello ";
		int res1=i1+i2;//Addition of two int-type is int-type
		float res2=i1+f3;//addition of one int and one float is float-type
		double res3=i2+d4;//addition of 1 int and 1 double is double
		String res4=h1+f3;//Concatination of 1 string and 1 float is concatination of both values.
		System.out.println("res1 = "+res1);
		System.out.println("res2 = "+res2);
		System.out.println("res3 = "+res3);
		System.out.println("res4 = "+res4);
		
		//Implicit type-casting
		byte by=15;
		byte by2=13;
		
		//Explicit type-casting
		byte by3=(byte)(by+by2);
		byte by4 = (byte)(124+64);
		System.out.println("Implicite type-casting: "+ by3);
		System.out.println("Implicite type-casting: "+ by4);

	}

}
