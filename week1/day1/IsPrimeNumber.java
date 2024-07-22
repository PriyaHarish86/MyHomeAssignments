package week1.day1;

public class IsPrimeNumber {

	// This main method is for checking whether a number is prime or not //
	public static void main(String[] args) {
		int n =23;
		boolean num1=false;
	// Check for 0 and 1 - Not prime numbers //
			if(n<=1) {
				 num1=true;
				}
	// Condition to check prime number or not from 2 to n-1 //
	for (int i = 2; i < n-1; i++) {
		if(n%i == 0) {
			num1=true;
			break;
			}
		}	
		if(num1==true) {
			System.out.println(n+ " is not a prime number");
		}
		else {
		System.out.println(n+ " is a prime number");
		}
		
	}
}