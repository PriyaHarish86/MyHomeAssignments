package week3.day1;

//CheckBoxButton Subclass which inherits Button sub class (Multi level Inheritance)
public class CheckBoxButton extends Button {

	public void clickCheckButton() {
		System.out.println("To select options from the checkboxes");
	}
	
	public static void main(String[] args) {
		CheckBoxButton cb=new CheckBoxButton();
		cb.click(); //This method is returned since Button subclass inherits WebElement base class
		cb.setText("Harish"); //This method is returned since Button subclass inherits WebElement base class
		cb.submit();
		cb.clickCheckButton();
		

	}

}
