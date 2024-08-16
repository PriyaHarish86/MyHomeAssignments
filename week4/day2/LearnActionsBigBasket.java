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

public class LearnActionsBigBasket {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);
		
		//Click on "Shop by Category
		driver.findElement(By.xpath("(//div[@class='relative h-full']//button)[2]")).click();
		Thread.sleep(5000);
		
		//Mouse over "Foodgrains, Oil & Masala"
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"))).perform();
		
		//Mouse over "Rice & Rice Products"
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"))).perform();
		Thread.sleep(5000);
		//Click on "Boiled & Steam Rice"
		act.click(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"))).perform();
		Thread.sleep(3000);
		
		//Filter the results by selecting the brand "bb Royal".
		WebElement sc = driver.findElement(By.id("i-BBRoyal"));
		act.scrollToElement(sc).perform();
		Thread.sleep(3000);
		sc.click();
		Thread.sleep(3000);
		
		//Click on "Tamil Ponni Boiled Rice"
		WebElement sc1 = driver.findElement(By.xpath("//h3[contains(text(),'Tamil Ponni Boiled Rice')]"));
		act.scrollToElement(sc1).perform();
		sc1.click();
		
		//switching to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wh=new ArrayList<String>(windowHandles);
		driver.switchTo().window(wh.get(1));		
		Thread.sleep(3000);
				
		//Select 5 Kg bag
		driver.findElement(By.xpath("//span[text()='5 kg']")).click();
		
		//Check and note the price of the rice
		String price = driver.findElement(By.xpath("//td[@class='Description___StyledTd-sc-82a36a-4 fLZywG']")).getText();
		System.out.println("The price of the rice is: " +price);
		
		//Click "Add" to add the bag to your cart
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		Thread.sleep(3000);
		
		//Verify the success message that confirms the item was added to your cart
		String text = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']")).getText();
		if(text.contains("success")) {
			System.out.println("Item has been added to the basket successfully");
		}
		else {
			System.out.println("Item not added to the basket");
		}
		Thread.sleep(3000);
		
		// Take a snapshot of the current page
		// Step 1: Use getScreenShotAs() method
		File scr = driver.getScreenshotAs(OutputType.FILE);
		// Step 2: set the path to be stored
		File dest = new File ("./SnapShots/Bigbasket.png");
		// Step 3: Connect Step 1 and 2
		FileUtils.copyFile(scr, dest);
		Thread.sleep(3000);
		
		//Close the current window
		driver.close();
		
		//Close the main window
		driver.switchTo().window(wh.get(0));
		driver.close();
		
	}
}