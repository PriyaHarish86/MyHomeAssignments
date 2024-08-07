package week3.day1;

//RadioButton Subclass which inherits Button sub class (Multi level Inheritance)
public class RadioButton extends Button{
	
	public void selectRadioButton() {
		System.out.println("To click on an option using radio button");
	}
	
	public static void main(String[] args) {
		RadioButton rb=new RadioButton();
		rb.click();
		rb.setText("Priya");
		rb.submit();
		rb.selectRadioButton();
	}

}
