package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjioListInterface {

	public static void main(String[] args) throws InterruptedException {
		//Launch the Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//Maximize the web page
		driver.manage().window().maximize();
		
		//Launch the URL
		driver.get("https://www.ajio.com/");
		
		//In the search box, type as "bags" and press enter
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags");
		driver.findElement(By.xpath("//button[@class='rilrtl-button']")).click();
		
		//Select Gender as 'Men' from the left pane
		driver.findElement(By.xpath("//label[contains(text(),'Men ')]")).click();
		Thread.sleep(3000);
		
		//Select Category as 'Fashion Bags' from the left pane
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags ')]")).click();
		
		Thread.sleep(3000);
		
		//Print the count of the items found
		String text = driver.findElement(By.xpath("//div[contains(@aria-label,'Items Found')]")).getText();
		System.out.println("The count of the items filtered based on Gender and Category is: " +text);
		
		System.out.println();
		Thread.sleep(3000);
		
		//Get the list of brand of the products displayed in the page and print the list
		driver.findElement(By.xpath("//span[text()='brands']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//strong[text()='MORE'])[2]")).click();
		
		List<WebElement> bp = driver.findElements(By.xpath("//span[@class='facet-list-title-name']"));
		int size=bp.size();
		System.out.println("List of Brand Names:");
		for(int i=0;i<size;i++){
			String text1 = bp.get(i).getText();
			System.out.println(text1);
		}
		
		System.out.println();
		
		//Close the Choose Brands wizard
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		Thread.sleep(3000);
		
		System.out.println();
		
		//Get the list of the bags names and print it
		List<WebElement> bn = driver.findElements(By.xpath("//div[@class='nameCls']"));
		int size1 = bn.size();
		System.out.println("List of Bag Names are:");
		for(int j=0;j<size1;j++){
			String text2 = bn.get(j).getText();
			System.out.println(text2);
			
		//driver.close(); //this returns connection reset exception since the list returned above is more.
			
		}		

	}

}
