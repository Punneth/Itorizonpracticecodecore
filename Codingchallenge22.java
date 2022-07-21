package javabasics;

/*	Question 2:
	Write a program to calculate the sum of the numbers from 1 till upper bound.
	If upper bound is 5, sum should be 1 + 2 + 3 + 4 + 5 = 15.
	If upper bound is 11, sum should be 1 + 2 + ... + 11 = 66.
	If upper bound is 100, sum should be 1 + 2 + ... + 100 = 5050.
*/
public class Codingchallenge22 {

	public static void main(String[] args) {
		int num = 100;
		int sum = 0;
		while(num > 0) {
			sum+=num;
			num--;
		}
		System.out.println(sum);
	}

}
