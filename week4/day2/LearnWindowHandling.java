package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		//Disable the notifications
		ChromeOptions cp =new ChromeOptions();
		cp.addArguments("--disable-notifications");
		
		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver(cp);
		//Maximize the browser window
		driver.manage().window().maximize();
		//Add implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Enter the username and password
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		//Click on Login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//Click on the CRM/SFA link
		driver.findElement(By.xpath("//a[contains(text(),' CRM')]")).click();
		//Click on Contacts button
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts link from the left panel
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//Click on the widget icon of "From Contact" field
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> wh = driver.getWindowHandles();
		//get(1) will return child window
		List<String> window = new ArrayList<String>(wh);
		//Switching to child window
		driver.switchTo().window(window.get(1));
		//Click on the first resulting contact
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//Bring the control to my parent/first window
		driver.switchTo().window(window.get(0));
		
		//Click on the widget icon of "To Contact" field
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> wh1 = driver.getWindowHandles();
		//get(1) will return child window
		List<String> window1 = new ArrayList<String>(wh1);
		//Switching to child window
		driver.switchTo().window(window1.get(1));
		//Click on second resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		//Bring the control to my parent/first window
		driver.switchTo().window(window.get(0));
		Thread.sleep(3000);
		
		//Click on Merge button
		driver.findElement(By.linkText("Merge")).click();
		
		//Accept the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println("The title of the page is: " +title);
		if(title.contains("View Contact "))
			System.out.println("The title of the page is correct");
		else
			System.out.println("The title of the page is incorrect");
		
		//Close the browser
		driver.close();
	}
}
