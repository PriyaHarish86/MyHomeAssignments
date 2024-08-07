package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementsusingList {

	public static void main(String[] args) {
		
		int [] arr= {1, 2, 3, 4, 10, 6, 8};
		int count=1;
		
		List <Integer> listArray=new ArrayList<Integer>();
		//iterating the values in the list
		int length = arr.length;
		for(int i= 0; i<length; i++) {
			listArray.add(arr[i]);
			}	
		
		//sorts list array in ascending order
		Collections.sort(listArray);
		System.out.println("The sorted array in ascending order is: " +listArray);
		
	
		int size = listArray.size();
		System.out.println("The array size is: " +size);
		
		System.out.println("The missing elements are: ");
		
		//Iteration to check if there a gap in the sequence of numbers 
		for(int j=0; j<size; j++) {
			//Use get() method to get an element from the list
			int num = listArray.get(j);
			//check if the current number + 1 is not equal to the next number
			//If yes, print the missing numbers
			if(count != num) {
				System.out.println(count);
				//System.out.println(count);
				count++;
			}
			count++;
		}
	}
}
