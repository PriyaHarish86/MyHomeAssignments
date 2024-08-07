package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionUsingList {

	public static void main(String[] args) {
		//Declare two arrays
		int [] arr1= {3, 2, 11, 4, 6, 7};
		int [] arr2= {1, 2, 8, 4, 9, 7};
		
		//Add array elements to a list
		List <Integer> listArray=new ArrayList<Integer>();
		
		//Find the length of the arrays
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		System.out.println("The intersection of both arrays are: ");
		
		//Iterate the values through the length of the list
		for (int i=0; i<len1;i++) {
			for (int j=0; j<len2; j++) {
				//Compare both the arrays and print the values
				if (arr1[i] == arr2[j]) {
					listArray.add(arr1[i]);
				}
			}
		}
		System.out.println(listArray);	
	}
}	
		
	//Another method
//		//Add array elements to a list
//		List <Integer> listArray1=new ArrayList<Integer>();
//		List <Integer> listArray2=new ArrayList<Integer>();
//		
//		//Find the length of the arrays
//		int len1 = arr1.length;
//		int len2 = arr2.length;
//		
//		//iterating the values in the list
//		for(int i= 0; i<len1; i++) {
//			listArray1.add(arr1[i]);
//		}	
//		
//		for(int j= 0; j<len2; j++) {
//			listArray2.add(arr2[j]);
//		}	
//		
//		System.out.println("The intersection of two arrays " + listArray1 + " " +"and" + " " + listArray2 + " is: ");
//		
//		//Iterate the values through the length of the list
//		for (int i=0; i<len1;i++) {
//			for (int j=0; j<len2; j++) {
//				//Compare both the arrays and print the values
//				if (arr1[i] == arr2[j]) {
//					System.out.println(arr2[j]);
//				}
//			}
//		}

