package javabasics;

/*	Question 3:
	Write a Java program to print all the numbers between 1 and 100 (including 1 and 100)
	which are divisible by 5.
*/
public class Codingchallenge33 {

	public static void main(String[] args) {
		int num = 100;
		for(int i=1;i<=100;i++) {
			if(i%5 == 0) {
				System.out.println(i);
			}
		}
	}

}
