package week3.day1;

//Subclass which inherits TestData Base class (Single level/Simple Inheritance)
public class LoginTestData extends TestData{
	public void enterUsername() {
		System.out.println("Enter User Name");
	}
	
	public void enterPassword() {
		System.out.println("Enter Password");
	}
	
	//Creating objects and calling the respective methods from LoginTestData class which also inherits the methods from TestData base class
	public static void main(String[] args) {
		LoginTestData login=new LoginTestData();
		login.enterCredentials();
		login.enterUsername();
		login.enterPassword();
		login.navigateToHomePage();
	}
}
