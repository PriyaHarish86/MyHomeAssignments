package week3.day1;

//Base Class
public class WebElement {

		public void click() {
			System.out.println("Click Method");
		}
		public void setText(String text) {
			System.out.println("The string set is: " +text);
		}
		
		public static void main(String[] args) {
			WebElement cd = new WebElement();
			cd.click();
			cd.setText("Priya");
		}
}
