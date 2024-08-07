package week3.day1;

//Button Subclass which inherits WebElement Base class (Hierarchical Inheritance)
public class Button extends WebElement{

		public void  submit(){
			System.out.println("Submit method");
		}
		
		public static void main(String[] args) {
			Button bu= new Button();
			bu.click();
			bu.setText("Lakshitha");
			bu.submit();
		}
}
