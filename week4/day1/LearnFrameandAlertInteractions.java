package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrameandAlertInteractions {

	public static void main(String[] args) throws InterruptedException {
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		// Switch to the frame
		driver.switchTo().frame("iframeResult");
		
		//Click "Try It" button inside the frame
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		//Click OK/Cancel in the alert that appears
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		
		//Confirm the action is performed correctly by verifying the text displayed
		String text = driver.findElement(By.id("demo")).getText();
		if(text.contains("Hello")) {
			System.out.println("Alerts and Frames are handled correctly");
		}
		// Return to the top level
		driver.switchTo().defaultContent();
		
		//Close the browser
		driver.close();
				
	}

}
