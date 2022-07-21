package arrrays.basics;

public class Arraychallenge1 {
		public static void main(String[] args) {
			int [] arr = new int [1000];
			int a = 1;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = a++;
			}
			
			int counter = 1;
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
				if(counter++ % 10 == 0) {
					System.out.println();
				}
			}
		}
	}
