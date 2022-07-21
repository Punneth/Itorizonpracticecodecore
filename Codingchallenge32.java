package javabasics;

/*	Question 2:
	Print the table of 12 using while loop.
	Output should be in following format:
	12 X 1 = 12
	12 X 2 = 24
	12 X 3 = 36
	12 X 4 = 48
	12 X 5 = 60
	12 X 6 = 72
	12 X 7 = 84
	12 X 8 = 96
	12 X 9 = 108
	12 X 10 = 120*/

public class Codingchallenge32 {

	public static void main(String[] args) {
		int num = 12;
		int i = 1;
		while(i <= 10) {
			System.out.println(num + " X " + i + " = " + (num*i));
			i++;
		}
	}

}
