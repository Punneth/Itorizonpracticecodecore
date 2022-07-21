package arrrays.basics;

public class Arraychallenge2 {
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for(int i = 0; i <= arr.length-1; i++) {
			arr[i] *= 19;
		}
		for(int j = 0; j <= arr.length-1; j++) {
			System.out.println(arr[j]);
		}
	}

}
