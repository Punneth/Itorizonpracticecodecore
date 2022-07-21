package javabasics;

/*	Question 4:
	Write a Java Program to solve Question 1 using ternary operator (?:).
*/
public class Codingquestions4 {

	public static void main(String[] args) {
		int marks = 56;
		System.out.println((marks < 60)?"Fail":(marks >= 90)?"Passed with distinction":"Pass");
	}

}
