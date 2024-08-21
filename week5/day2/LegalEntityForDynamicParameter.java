package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LegalEntityForDynamicParameter extends ProjectSpecificMethodUsingParameters {
	
		@DataProvider(name="EntityName")
		public String[][] setValue(){
			String[][] data = new String[1][1];
			data[0][0] = "PriyaHarish";
			
			return data;
		}
		
		@Test(dataProvider = "EntityName")
		public void loginSalesforce(String leName) throws InterruptedException {
			
			//Click on the toggle menu button from the left corner
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//Click View All 
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
			
			//Click Legal Entities from App Launcher
			WebElement ele=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
			Actions opt=new Actions(driver);
			opt.scrollToElement(ele).perform();
			ele.click();
			
			//Click on the Dropdown icon in the legal Entities tab
			driver.findElement(By.xpath("(//*[local-name()='svg' and @data-key='chevrondown'])[6]")).click();
			Thread.sleep(3000);
			
			//Click on New Legal Entity
			WebElement js = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
			driver.executeScript("arguments[0].click();", js);
						
			//Enter Name as 'Salesforce Automation by *Your Name*'(Parameterized value)
			driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by " +leName);
			Thread.sleep(3000);
			
			//Click on Save
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
			
			//Vrify Legal Entity Name
			String text=driver.findElement(By.xpath("//slot[contains(@class,'slds-page-header__title slds-m-right--small')]//lightning-formatted-text[1]")).getText();
			if(text.contains(leName)){
				System.out.println("The Legal Entity is created successfully");
			}else
			{
				System.out.println("The Legal Entity is not created");
			}
			Thread.sleep(3000);
			
	}
}
	
