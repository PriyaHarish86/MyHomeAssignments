package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		//This program is to generate fibonacci series for range of numbers upto 8
		
		int maxNumbers = 8;
		int num1 = 0, num2 = 1;
		System.out.print("The fibonacci series in the range are: " +"\n");
		for (int i = 0; i <maxNumbers; i++) {
			System.out.println(num1 + " ");
			int nextNum = num1+num2;
			num1 = num2;
			num2=nextNum;
			}
	}
}