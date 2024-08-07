package week3.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNumberOfLinks {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		//return type findElements is "List<WebElement>"
		List<WebElement> totalLink = driver.findElements(By.tagName("a"));
		int size = totalLink.size();
		System.out.println("Total number of links in the web page are: " +size);
		
		
//		String text = totalLink.get(2).getText();
//		System.out.println("Text in the index of 2 is: " +text);
		
		System.out.println("The text presented in the links are: ");
		
		for (int i = 0; i < size; i++) {
			String text1 = totalLink.get(i).getText();
			System.out.println(text1);
			
		}
		
		driver.close();
	}

}
