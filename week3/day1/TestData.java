package week3.day1;

//Base class
public class TestData {
	public void enterCredentials() {
		System.out.println("Provide login credentials");
	}
	
	public void  navigateToHomePage() {
		System.out.println("Navigate to the home page");
	}
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.enterCredentials();
		td.navigateToHomePage();
	}
}
