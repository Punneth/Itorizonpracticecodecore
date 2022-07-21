package javabasics;

/*	Question 4:
	Print the multiples of 5 starting from 200 to 5 with following restrictions:
	1. Use for loop
	2. Don't use modulus (%) operator to check whether number is divisible by 5 or not.
*/

public class Codingchallenge34 {

	public static void main(String[] args) {
		int num = 5;
		for(int i=200;i>=num;i=i-5) {
			System.out.println(i);
		}
	}

}
