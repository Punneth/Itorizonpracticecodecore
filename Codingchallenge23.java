package javabasics;

/*	Question 3:
	Write a program using while loop to print Even numbers from 1 to 100.
*/
public class Codingchallenge23 {

	public static void main(String[] args) {
		int num = 1;
		while(num++ <= 100) {
			if(num%2 == 0) {
				System.out.println(num);
			}
			num++;
		}
	}

}
