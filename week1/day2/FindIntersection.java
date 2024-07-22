package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		
	// Declaring two arrays here
			int[] array1 = {3,2,11,4,6,7};
			int[] array2 = {1,2,8,4,9,7};
			
		System.out.println("The intersection of two arrays are: " );
		// Iterate two arrays and compare the values in both
		for (int i = 0; i<array1.length; i++) {
			for (int j= 0; j< array2.length; j++) {
				{if (array1[i]==array2[j])
				{
				System.out.println(array1[i]);
				break; 
				}
				}
			}
		}
	}	
}

