package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnRadioButton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.manage().window().maximize();
		
		//Click on a radio button "Firefox", then click on the same radio button again to verify that it becomes ‘unselected’.
		driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).click();
		
		String text = driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).getText();
		
		System.out.println("1st selected option is: " + text);
		
        //Verify whether the radio button is selected or not using the method isSelected();
        //returns true if element is selected; else returns false
        boolean isEnabledButton = driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).isEnabled();
        System.out.println("Confirming the 1st selected option as : " + text + " is " + isEnabledButton);
        
//             
//        if(isEnabledButton==true) {
//        	driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).click();
//        	String text1 = driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).getText();
//        	System.out.println("2nd selected option is: " + text1);
//        }
        
        //isSelected
        //returns true if element is checked else returns false
        driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).click();
        boolean isSelectedCheck = driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).isSelected();
        if(isSelectedCheck==false) {
        	String text1 = driver.findElement(By.xpath("(//h5[text()='Your most favorite browser']/following::label)[2]")).getText();
        	System.out.println("The radio button: " + text1 + " is not selected when clicking the same option again");
        }
        
        //Identify the radio button that is initially selected by default using isEnabled() method works 
//        boolean isEnabledButton1 = driver.findElement(By.xpath("(//h5[text()='Find the default select radio button']/following::label)[3]")).isEnabled();
//        String text2 = driver.findElement(By.xpath("(//h5[text()='Find the default select radio button']/following::label)[3]")).getText();
//        System.out.println("The radio button: " + text2 + " is selected by default in Find the default select radio button section " + isEnabledButton1);
        
        //Identify the radio button that is initially selected by default using isSelected() method
        boolean selected = driver.findElement(By.xpath("(//label[text()='Safari'])[2]/preceding::input[1]")).isSelected();
        if(selected==true) {
        	String text2 = driver.findElement(By.xpath("(//h5[text()='Find the default select radio button']/following::label)[3]")).getText();
        	System.out.println("The radio button: " + text2 + " is selected by default in Find the default select radio button section ");
        }
        
        //check if the age group (21-40 Years) is selected or not
        driver.findElement(By.xpath("//label[text()='41-60 Years']")).click();
     	String text3 = driver.findElement(By.xpath("(//h5[contains(text(),'Select the age group')]/following::label)[3]")).getText();
        System.out.println("The selected age group is: " + text3);
        
        Thread.sleep(5000);
        driver.close();
        
	}

}
