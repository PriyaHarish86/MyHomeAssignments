package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		
			String test = "changeme";
			
			//convert the given String to character array
			char[] charArray = test.toCharArray();
			
			int length=charArray.length;
			
			//iterate through each character of the String
			for (int i=0; i<length; i++) {
				//To find the odd index of the string
				if(i % 2 != 0) {
					
					//use toUpperCase() from Character class to convert odd index values to uppercase
					charArray[i]=Character.toUpperCase(charArray[i]);
				}
			}
			
			System.out.print("The string after changing odd index to uppercase is: ");
			System.out.println(charArray);
	}

}
