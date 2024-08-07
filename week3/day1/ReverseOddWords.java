package week3.day1;

public class ReverseOddWords {
	public static void main(String[] args) {
		String test = "I am a software tester";
		System.out.println("The orginal string is: " +test);
		
		//Split the words and have it in an array
		String[] split = test.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i= 0; i<split.length; i++) {
			//Find the odd index within the loop
			if(i % 2 ==1) {
			char[] charArray = split[i].toCharArray();  //Convert the String array into a character array
			String reversedWord="";
				// Print the odd position words using another loop
				for(int j=charArray.length; j>0; j--) {
					reversedWord+= String.valueOf(charArray[j-1] );
				}
				result.append( reversedWord ).append( " " );
			}
			else {
				result.append( split[i] ).append( " " );
			}
		}
		
		System.out.println("The reversed string in the odd position is: " + result.toString() );
		
	}
}
