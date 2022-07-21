package javabasics;

/*	Question 2:
	Print following output using nested while loops:
	1
	22
	333
	4444
	55555
	666666
	7777777
*/


public class Codingchallenge42 {

	public static void main(String[] args) {
		int num = 7;
		int i=1;
		while(i<=num) {
			int j=1;
			while(j<=i) {
				System.out.print(i);
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
