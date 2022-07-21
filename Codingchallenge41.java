package javabasics;

/*	Question 1:
	Print following output using nested for loops:
	1
	22
	333
	4444
	55555
	666666
	7777777
*/

public class Codingchallenge41 {

	public static void main(String[] args) {
		int num =7;
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
