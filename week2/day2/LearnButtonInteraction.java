package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnButtonInteraction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		 // Click on the element "Click and Confirm title"
        WebElement checkInput=driver.findElement(By.xpath("//button[@role='button']//span[contains(text(),'Click')]"));
        checkInput.click();
		
        //To return the title of the page using getTitle()
      	String title = driver.getTitle();
      	System.out.println(title);
      		
      	if(title.contains("Dashboard")) {
      		System.out.println("The page title is : " +title);
      	}else
      	{
      		System.out.println("The page title is not : " +title);
      	}
      	
      	driver.navigate().back();      	
      	
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled using isEnabled() method
      	boolean isDisabledButton = driver.findElement(By.xpath("//span[contains(text(),'Disabled')]")).isEnabled();
      	System.out.println("Confirm if the button is disabled : " + isDisabledButton );
      	
      	//Find and print the position of the button with the text ‘Submit’ using getLocation() method
      	WebElement element = driver.findElement(By.xpath("(//button[@name='j_idt88:j_idt94']//span)[2]"));
      	Point location = element.getLocation();
      	System.out.println("The location of X is :" + location.getX() + "," +"Location of Y :" +location.getY());
      	System.out.println("The Position of Submit button in 'Find the position of the Submit button' : " + element.getLocation());
      	
      	// Find and print the background color of the button with the text ‘Find the Save button color' using getCssValue() method
      	WebElement cssValue = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        System.out.println("The background color of Save button : " + cssValue.getCssValue("background-color"));
        
        //Find and print the height and width of the button with the text ‘Find the height and width of this button’ using getSize() method
        WebElement res =  driver.findElement(By.xpath("(//button[@name='j_idt88:j_idt98']//span)[2]"));
        Dimension size = res.getSize();
		System.out.println("The height and width of submit button in 'Find the height and width of this button' is : " + size);
		System.out.println("Width :"+size.getWidth()+ "," +"Height : "+size.getHeight());
        
		Thread.sleep(2000);
        driver.close();
    }
}
