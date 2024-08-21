package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethodUsingParameters {
	
	//Base class
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	
	@BeforeMethod
	public void preCondition(String url, String uname, String pwd) {
		//Ignore Notifications
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		
		//Pass the URL as parameter value from xml file
		driver.get(url);
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Enter username using parameter value from xml file
		driver.findElement(By.id("username")).sendKeys(uname);
		//Enter username using parameter value from xml file
		driver.findElement(By.id("password")).sendKeys(pwd);
		//Click on Login
		driver.findElement(By.id("Login")).click();
		
	}
	
	@AfterMethod
	public void postCondition() {
		//Close the browser
		driver.close();
	}
	
}
