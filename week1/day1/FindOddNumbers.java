package week1.day1;

public class FindOddNumbers {

	// This program is to find the odd numbers in a range of numbers
	public static void main(String[] args) 
	{
		int maxRange=10;
		String name = "The odd numbers are: ";
		System.out.print(name);
		for (int i = 0; i <=maxRange; i++) 
		{
			if(i%2==1) 
			{
			System.out.print(i + " ");
			}
		}
	}
}