package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethod {
	
	//Base class
		public ChromeDriver driver;
		
	@BeforeMethod
	public void preCondition() {
		//Ignore Notifications
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		
		//Load the URL
		driver.get("https://login.salesforce.com/");
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Enter UserName
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("testleaf@2024");
		//Click on Login
		driver.findElement(By.id("Login")).click();
		
	}
	
	@AfterMethod
	public void postCondition() {
		//Close the browser
		driver.close();
	}
	
}
