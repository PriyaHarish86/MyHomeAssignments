package week3.day1;

//TextField Subclass which inherits WebElement Base class (Hierarchical Inheritance)
public class TextField extends WebElement {
	
	public void getText(){
		System.out.println("This method will return the text value");
	}
	
	public static void main(String[] args) {
		TextField tf= new TextField();
		tf.click();
		tf.setText("Lakshitha");
		tf.getText();
		//tf.submit(); //This method will be called here and throws error since TextField subclass inherits only WebElement Base class and not Button subclass
	}

}
