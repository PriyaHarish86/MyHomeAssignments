package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFBAccountwithSelectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("testFN");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("testLN");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following::input[1]")).sendKeys("9845123651");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("testtesttest");
		
		
		//Using select class method to handle drop down options
		WebElement selectElement = driver.findElement(By.name("birthday_day"));
		Select select = new Select(selectElement);
		select.selectByValue("26");
		
		WebElement selectElement1 = driver.findElement(By.name("birthday_month"));
		Select select1 = new Select(selectElement1);
		select1.selectByVisibleText("Aug");
		
		WebElement selectElement2 = driver.findElement(By.name("birthday_year"));
		Select select2 = new Select(selectElement2);
		select2.selectByValue("1985");
		
		//Use click() to handle radio buttons
		driver.findElement(By.xpath("(//input[@type='radio']//parent::span)[3]")).click();
		driver.findElement(By.xpath("//label[text()='Custom']/following::select[@name='preferred_pronoun']/option[3]")).click();	
		driver.findElement(By.xpath("//label[text()='Custom']/following::input[2]")).sendKeys("Male");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
	}

}
