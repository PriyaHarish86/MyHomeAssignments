package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Ignore the notifications
		ChromeOptions cp =new ChromeOptions();
		cp.addArguments("--disable-notifications");
		
		//Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver(cp);
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the URL
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(5000);
		
		//Go to "Men's Fashion"
		Actions act = new Actions(driver);
		WebElement mo = driver.findElement(By.xpath("//span[@class='catText']"));
		act.moveToElement(mo).perform();
		
		// Go to "Sports Shoes"
		WebElement cl = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		act.click(cl).perform();
		
		//Get the count of sports shoes
		String text = driver.findElement(By.xpath("//div[@class='category-name-wrapper clearfix ']//span")).getText();
		System.out.println("The count of sport shoes for men: " +text);
		
		//Click on "Training Shoes"
		WebElement cl1 = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		act.click(cl1).perform();
		
		//Sort the products by "Low to High"
		WebElement js = driver.findElement(By.xpath("//li[text()[normalize-space()='Price Low To High']]"));
		driver.executeScript("arguments[0].click();", js);
		Thread.sleep(5000);
		
		//Check if the displayed items are sorted correctly
		List<WebElement> elements = driver.findElements(By.cssSelector("[class='lfloat product-price']"));
		List<Integer> price = new ArrayList<Integer>();
		int n=elements.size();
		for (int i=0; i<n; i++) {
			String text1 = elements.get(i).getAttribute("data-price");
			price.add(Integer.parseInt(text1));
			}
		List<Integer> sortPrice=new ArrayList<Integer>();
		sortPrice.addAll(price);
		Collections.sort(sortPrice);
		if(sortPrice.equals(price)) {
			System.out.println("The displayed items are sorted correctly");	
	     }
		else {
			System.out.println("The sorting of the items are incorrect");
		}
		
		//Select any price range ex:(500-700)
		WebElement element = driver.findElement(By.xpath("//input[@class='input-filter']"));
		element.clear();
		element.sendKeys("500");
		WebElement element1= driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		element1.clear();
		element1.sendKeys("700");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		
		//Filter by any colour
		WebElement sc = driver.findElement(By.xpath("//input[@id='Color_s-Black']/following-sibling::label[1]"));
		act.scrollToElement(sc).perform();
		Thread.sleep(5000);
		sc.click();
		
		//Verify all the applied filters
		boolean displayed = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div")).isDisplayed();
		if(displayed == true)
		{
			System.out.println("All Filters are applied correctly");
		}
		Thread.sleep(3000);
		
		//Mouse hover on the first resulting "Training Shoes".
		act.moveToElement(driver.findElement(By.xpath("//img[@class='product-image wooble']"))).perform();
		Thread.sleep(3000);
		//Click the "Quick View" button
		driver.findElement(By.xpath("//div[text()[normalize-space()='Quick View']]")).click();
		
		//Print the cost and discount percentage
		String text1 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("The cost and the discount percentage is: " +text1);
		
		Thread.sleep(3000);
		
		// Take Snapshot of the shoes
		WebElement ss = driver.findElement(By.xpath("//div[contains(@class,'quickViewModal ')]"));

		// Step 1: Use getScreenShotAs() method
		File scr = ss.getScreenshotAs(OutputType.FILE);		
		// Step 2: set the path to be stored
		File dest = new File ("./SnapShots/TrainingShoe.png");		
		// Step 3: Connect Step 1 and 2
		FileUtils.copyFile(scr, dest);

		// Close the current window
		WebElement cw = driver.findElement(By.xpath("//div[contains(@class,'close close1')]//i[1]"));
		act.click(cw).perform();
		
		// Close the main window
		driver.close();
		
	}

}
