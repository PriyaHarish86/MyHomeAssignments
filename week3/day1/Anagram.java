package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// Define two input strings
		String str1 = "Stops";
	    String str2 = "Potss";
	    
	    //convert the strings to lowercase if it has case sensitivity
	    str1 = str1.toLowerCase();
	    str2 = str2.toLowerCase();
	    
	  	// check if lengths of the two strings are same
	    if(str1.length() == str2.length()) {

	      // convert both the strings to char array
	      char[] charArray1 = str1.toCharArray();
	      char[] charArray2 = str2.toCharArray();

	      // sort both the char array
	      Arrays.sort(charArray1);
	      Arrays.sort(charArray2);

	      // if sorted char arrays are same then the string is anagram
	      boolean result = Arrays.equals(charArray1, charArray2);
	      if(result) {
	        System.out.println("The given strings " + "'" + str1 + "'" + " and " + "'" + str2 + "'" + " are Anagram.");
	      }
	      else {
	        System.out.println("The given strings " + "'" + str1 + "'" + " and " + "'" + str2 + "'" + " are not Anagram.");
	      }
	    }
	    else {
	      System.out.println("Lengths mismatch, and hence the given strings " + "'" + str1 + "'" + " and " + "'" + str2 + "'" + " are not Anagram.");
	    }
	}
}
