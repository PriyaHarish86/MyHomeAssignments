package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL
		driver.get("https://www.amazon.in/");
		
		//. Search for "oneplus 9 pro"
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of the first product is: " +price);
		
		//Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("(//div[@class='a-row a-size-small']//a[@target='_blank'])[1]")).getText();
		System.out.println("The number of customer ratings for the first displayed product is: " +rating);
		
		// Click the first text link of the first image
		driver.findElement(By.xpath("(//span[contains(text(),'OnePlus 9 Pro')])[1]")).click();
		Thread.sleep(5000);
		
		//Window Handling
		Set<String> wh = driver.getWindowHandles(); 
		//Convert Set into List using get() method
		//get(1) will return child window
		List<String> window = new ArrayList<String>(wh);
		//Switching to child window
		driver.switchTo().window(window.get(1));
		
		// Take a screenshot of the product displayed
		// Step 1: Use getScreenShotAs() method
		File scr = driver.getScreenshotAs(OutputType.FILE);
		// Step 2: set the path to be stored
		File dest = new File ("./SnapShots/Amazon.png");
		// Step 3: Connect Step 1 and 2
		FileUtils.copyFile(scr, dest);
		Thread.sleep(5000);
		
		//Click the 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		//Get the cart subtotal and verify if it is correct
		String text = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("The cart subtotal is " +text);
		if(text.contains(price)) {
			System.out.println("The cart subtotal is correct");
		}
		else {
			System.out.println("The cart subtotal is incorrect");
		}
		
		//Close all the browser
		driver.quit();
		
		}
}
