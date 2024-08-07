package week3.day1;

//import java.util.LinkedHashSet;
//import java.util.Set;

public class RemoveDuplicateWords {
	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		System.out.println("The orginal string is: " +text);
		int count;		
	 	//Split the string into words using built-in function  
		String[] arr = text.split(" "); //arr=We,learn,java,basics,as,part,of,java,sessions,in,java,week1
		
		System.out.println("Duplicate words in the given string : ");
		int n=arr.length;
		
		// Use for loop to remove duplicate words
		for(int i=0;i<n;i++){
			count=1;
			for(int j = i+1; j < n; j++) { 
				//Use equalsIgnoreCase to ignore case sensitivity
				if(arr[i].equalsIgnoreCase(arr[j])) {
					//Set arr[j] to empty string to avoid printing visited word  
					arr[j] = " ";  
					count++;
				}
			}
				//Displays the duplicate word if count is greater than 1  
	          	if(count > 1 && arr[i] != " ")  {
	            	System.out.println(arr[i]);
	            	//Print the string after removing the duplicates
	            	System.out.println("The output of the string after removing duplicates: ");
	            	for(int k=0;k<n;k++) {
	            		System.out.print(arr[k] + " ");
	            	} 
	           }
			}
	 }
}

//	//Another way by creating methods using Hashsetand call it in main method
//	 public static String removeDuplicates(String text) {
//		//Converts the string into lowercase  
//		text = text.toLowerCase();  
//		System.out.println("The string is: " +text);
//		
//		//Split the words and have it in an array
//		String[] split = text.split("\\s+");
//		Set<String> wordSet = new LinkedHashSet<>();
//        StringBuilder result = new StringBuilder();
//
//        for (String word : split) {
//            if (!wordSet.contains(word)) {
//                wordSet.add(word);
//                result.append(word).append(" ");
//            }
//        }
//
//        return result.toString().trim();
//	}
//	
//	public static void main(String[] args) {
//		String text = "We learn Java basics as part of java sessions in java week1";
//		System.out.println("The orginal string is: " +text);
//		String result = removeDuplicates(text);
//		System.out.println("The output of the string after removing duplicates: " + result);
//	}
//}



