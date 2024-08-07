package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumUsingList {

	public static void main(String[] args) {
		//Declaring array with list of numbers
		int [] arr= {3, 2, 11, 4, 6, 7};
		
		List <Integer> listArray=new ArrayList<Integer>();
		
		//iterating the values in the list
		int length = arr.length;
		for(int i= 0; i<length; i++) {
			listArray.add(arr[i]);
		}	
		
		//sorts list array in ascending order
		Collections.sort(listArray);
		System.out.println("The sorted array in ascending order is: " +listArray);
		
		//Find the position of the second largest element in the array
		int size = (listArray.size())-2;
		System.out.println("The index position of the second largest element from the last is: " +size);
		
		System.out.println();
		
		System.out.print("The second largest element from the last in the array after sorting is: ");
		System.out.println(listArray.get(size)); //Pick the 2nd element from the last and use get() method to print the second largest number

	}

}
