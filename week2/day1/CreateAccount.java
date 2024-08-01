package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),' CRM')]")).click();
		
		driver.findElement(By.xpath("//div[@class='x-panel-header']//a[contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[text()[normalize-space()='Accounts']]/following::a[text()[normalize-space()='Create Account']]")).click();
		driver.findElement(By.xpath("//span[text()='Account Name']/following::input")).sendKeys("TestAccount1001");
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("LeafTaps");
		driver.findElement(By.xpath("//input[@id='numberEmployees']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		//To return the title of the page
		String title = driver.getTitle();
		System.out.println(title);
	
		if(title.contains("Details")) {
		System.out.println("The browser title is : " +title);
		}else
		{
			System.out.println("The browser title is not : " +title);
		}
		
		driver.close();
		
	}

}
