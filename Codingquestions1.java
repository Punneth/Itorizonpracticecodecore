package javabasics;

/*
	Question 1:
	Write a java program for following logic.
    if marks < 60, then print "Fail"
    if marks >= 60 but less than 90 , then print "Pass"
    if marks >= 90, then print "Passed with Distinction"
 */

public class Codingquestions1 {

	public static void main(String[] args) {
		int marks = 98;
		if(marks < 60) {
			System.out.println("Fail");
		}
		else if(marks >= 90) {
			System.out.println("Pass with Distinction");
		}
		else {
			System.out.println("Pass");
		}
	}

}
