package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LegalEntityForStaticParameter extends ProjectSpecificMethodUsingParameters {
	
		@Test
		public void loginSalesforce() throws InterruptedException {
			
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
						
			//Enter the Company name as 'TestLeaf'
			driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("TestLeaf");
			
			//Enter Description as 'Salesforces"
			driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys("Salesforces");
			
			//Select Status as 'Active'
			driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
			driver.findElement(By.xpath("//span[text()='Active']")).click();
			
			//Click on Save
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
			
			//Verify the Alert message (Complete this field) displayed for Name
			String alert=driver.findElement(By.xpath("(//div[@part='help-text'])[2]")).getText();
			if(alert.contains("Complete this field")) {
				System.out.println("The alert message for Legal Entity Name is displayed correctly");
			}else
			{
				System.out.println("The alert message for Legal Entity Name is not displayed");
			}
			Thread.sleep(3000);
	}
}
	
