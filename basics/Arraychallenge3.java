package arrrays.basics;

public class Arraychallenge3 {
	public static void main(String[] args) {
		char arr [] = new char[] {'A', 'Z', 'B', 'N', 'P', 'T', 'X', 'C'};
		char key = 'B';
		boolean found = false; 
		for(int i = 0; i <= arr.length-1; i++) {
			if(arr[i] == key) {
				found = true;
				break; 
			}
		}
		
		if(found) {
			System.out.println(key + " found!");
		} else {
			System.out.println(key + " Not found!");
		}
	}

}
