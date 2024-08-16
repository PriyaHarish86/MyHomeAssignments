package week4.day1;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChar {

	public static void main(String[] args) {
		
		String name="Selenium";
		//output = Selnium
		char[] ch= name.toCharArray();
		
		Set<Character> unqi = new LinkedHashSet<Character>();
		
		for(Character character : ch) {
			unqi.add(character);
		}
			System.out.println("After removing duplicate char 'e' using LinkedHashSet is " +unqi);
			System.out.println();
			
			String empty = "";
			//To print the output in String as "Selnium" using for loop
			for (Character str : unqi) {
				empty+=str;
			}
			System.out.println("The output after removing duplicate char 'e' from the string " + name + " is: " +empty);
	}

}
