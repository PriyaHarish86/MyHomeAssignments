package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUsingCollections {
	public static void main(String[] args) {
		//Declare a String array and add the values
			String[] compName= {"HCL", "Wipro", "Aspire Systems", "CTS"};
				
			//Convert String Array to List
			List <String> lc =new ArrayList<String>();
			
			//iterating the values in the list
			int length = compName.length;
			for(int i= 0; i<length; i++) {
					lc.add(compName[i]);
				}	
			
			//sorts string array in ascending order
			Collections.sort(lc);
			System.out.println("The sorted array in ascending order is: " +lc);
			
			System.out.println();
			
			//Use reverse loop to iterate the collection
			int len=lc.size();
			System.out.println("The sorted array in reverse/descending order is: ");
			for (int j=len-1; j>=0; j--) {
				//prints the sorted string array in reverse/descending order 
				String result = lc.get(j);
				System.out.print(result + " ");
			}
	}
}	