package week3.day1;

//ExecutionClass_Elements class inherits Button sub class which then inherits WebElement Base class (Hybrid Inheritance)
public class ExecutionClassElements extends Button{

	//Execution class to call the methods from Button subclass which then calls the method from WebElement Base class
	public static void main(String[] args) {
		ExecutionClassElements ele= new ExecutionClassElements();
		ele.click();
		ele.setText("Mohanapriya");
		ele.submit();
	}

}
