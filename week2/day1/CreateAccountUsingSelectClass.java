package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountUsingSelectClass {

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
		driver.findElement(By.xpath("//span[text()='Account Name']/following::input")).sendKeys("TestAccount1110");
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("Selenium Automation Tester");
		
		//xpath to return "Computer Software" as the industry from the dropdown list
		driver.findElement(By.xpath("(//select[@class='inputBox'])[2]/option[4]")).click();
		
		//Another way to select Dropdown option "Computer Software" as the industry using select class
		//WebElement selectElement = driver.findElement(By.name("industryEnumId"));
		//Select select = new Select(selectElement);
		//select.selectByVisibleText("Computer Software");
        
		//Selected Dropdown option "S-Corporation" as the ownership using selectByVisibleText
		WebElement selectElement = driver.findElement(By.name("ownershipEnumId"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("S-Corporation");
		
		//Selected Dropdown option "EMPLOYEE" as the source using selectByValue
		WebElement selectElement1 = driver.findElement(By.name("dataSourceId"));
		Select select1 = new Select(selectElement1);
		select1.selectByValue("LEAD_EMPLOYEE");
		
		//Selected Dropdown option "eCommerce Site Internal Campaign" as the marketing campaign using selectByIndex
		WebElement selectElement2 = driver.findElement(By.name("marketingCampaignId"));
		Select select2 = new Select(selectElement2);
		select2.selectByIndex(6);
		
		//Selected Dropdown option "Texas" as state/province using selectByValue
		WebElement selectElement3 = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select select3 = new Select(selectElement3);
		select3.selectByValue("TX");
		
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		//get text from web application
		//WebElement text = driver.findElement(By.xpath("//span[class(),'tabletext'])[3]"));
		String text = driver.findElement(By.xpath("//span[contains(text(),'TestAccount1110')]")).getText();
		System.out.println(text);
						
		if(text.contains("TestAccount1110")) {
			System.out.println("Account created successfully : " +text);
		}else {
			System.out.println("Account not created : " +text);
		
		driver.close();
		
		}
			
	}
}
