package week1.day2;

import java.util.Arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		// To find out missing element in array
		int[] array = {1,4,3,2,8,6,7};
		Arrays.sort(array); //This will sort the array values
		for (int i = 0; i < array.length-1;i++) {
			if (array[i]+1 != array[i+1]) {
				System.out.println("Missing element is: " + (array[i]+1));
			}
		}
	}
}
