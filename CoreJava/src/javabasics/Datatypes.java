package javabasics;

public class Datatypes {
	public static void main(String[] args) {
		//Primitive data-types.
		byte a = 25;//positive byte data-type.
		byte b = -25;//negative byte data-type.
		
		System.out.println("Positive byte value: "+ a);
		System.out.println("Negative Byte value: "+ b);
		
		short c = 456;//Positive short value.
		short d = -456;//Negative short value.
		System.out.println("Positive short value "+ c);
		System.out.println("Negative short value "+ d);
		
		long l=85_65_4_436L;
		long m=-8_5654_43__6L;
		System.out.println("Positive long value "+ l);
		System.out.println("Negative long value "+ m);
		
		char c1='A';
		char c2=65;
		char c3='\u0041';
		System.out.println("The value of c1 is: "+ c1);
		System.out.println("The value of c2 is: "+ c2);
		System.out.println("The value of c3 is: "+ c3);
		
	//Assigning char literal to integer data-type
		byte i1='A';
		int i2='\u20B9';
		System.out.println("Assigning value of char to byte: "+i1);
		System.out.println("Assigning value of char to int: "+i2);
		
		boolean bl=true;
		System.out.println("Eligible to appear for the exam?"+bl);

	}

}
