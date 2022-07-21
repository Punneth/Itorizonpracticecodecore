package javabasics;

/*	Write a logic using switch-case to print "EVEN" / "ODD" for the numbers.
	Numbers divisible by 2 are even and numbers not divisible by 2 are odd.
*/
public class Codingquestions2 {

	public static void main(String[] args) {
		int num = 47;
		switch(num%2) {
		case 0:
			System.out.println("Even");
			break;
		case 1:
			System.out.println("Odd");
		}
	}

}
