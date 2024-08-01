package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
		
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
        boolean isSelectedCheck = driver.findElement(By.xpath("//span[text()='Basic']/preceding::input[@name='j_idt87:j_idt89_input']")).isSelected();
        if(isSelectedCheck==true) {
        	System.out.println("Basic check box is selected");
        }
        
        driver.findElement(By.xpath("//span[text()='Ajax']")).click();
        
        String text1 = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		boolean text = driver.findElement(By.xpath("//span[text()='Checked']")).isDisplayed();
		if(text==true) {
			System.out.println("Notification message for " + text1 + " is displayed correctly");
		}
		else {
			System.out.println("Notification message for " + text1 + "is not displayed");
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		driver.findElement(By.xpath("//label[text()='Python']")).click();
		
		driver.findElement(By.xpath("(//div[@id='j_idt87:ajaxTriState']//div)[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'State has been changed')]/following::p")).click();
		Thread.sleep(3000);

		WebElement displayed = driver.findElement(By.xpath("(//div[@class='ui-growl-message']//span)[1]"));
		String text2 = driver.findElement(By.xpath("//p[contains(text(),'State')]")).getText();
		if (displayed.isDisplayed()==true) {
			System.out.println("The state name is: " + text2);
			System.out.println("Notification message for " + text2 + " is displayed correctly");
		}
		else{
			System.out.println("Notification message for " + text2 + " is not displayed");
		}
		
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();	
		
		Thread.sleep(3000);
		
		String text3 = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		boolean text4 = driver.findElement(By.xpath("//span[text()='Checked']")).isDisplayed();
		if(text4==true) {
			System.out.println("Notification message for Toggle Switch " + text3 + " is displayed correctly");
		}
		else {
			System.out.println("Notification message for Toggle Switch " + text3 + "is not displayed");
		}
		
		String checkbox1 = driver.findElement(By.xpath("//h5[text()='Verify if check box is disabled']")).getText();
        boolean selected = driver.findElement(By.xpath("//span[contains(text(),'Disabled')]/preceding::input[@id='j_idt87:j_idt102_input']")).isSelected();
        if(selected==true) {
        	System.out.println("The check box in " + checkbox1 + " section is enabled");
        }
        else {
        	System.out.println("The check box in " + checkbox1 + " by default");
        }
                  
        driver.findElement(By.xpath("(//div[@class='ui-helper-hidden']/following-sibling::ul)[1]")).click();
        List<WebElement> multiChkBoxes = driver.findElements(By.xpath("(//div[contains(@class, 'ui-selectcheckboxmenu-panel ui-widget ui-widget-content ui-corner-all ui-helper-hidden ui-input-overlay')]//ul/li/div[@class='ui-chkbox ui-widget'])")).subList(0, 9);
        multiChkBoxes.get(1).click();
        multiChkBoxes.get(3).click();
        multiChkBoxes.get(8).click();
        
        Thread.sleep(5000);
        //To get the count of all checkbox options from the drop down
        System.out.println("Total no. of checkboxes in Select Multiple section: " +multiChkBoxes.size());
        
        WebElement displayed1= driver.findElement(By.xpath("//ul[@data-label='Cities']//following::span[@class='ui-selectcheckboxmenu-token-label']"));
        String chkboxItems=driver.findElement(By.xpath("(//ul[@data-label='Cities']//following::span[@class='ui-selectcheckboxmenu-token-label'])[1]")).getText();
        String chkboxItems1=driver.findElement(By.xpath("(//ul[@data-label='Cities']//following::span[@class='ui-selectcheckboxmenu-token-label'])[2]")).getText();
        String chkboxItems2=driver.findElement(By.xpath("(//ul[@data-label='Cities']//following::span[@class='ui-selectcheckboxmenu-token-label'])[3]")).getText();
        if(displayed1.isDisplayed()==true) {
        	System.out.println("The multiple cities selected are " + chkboxItems + ", "  + chkboxItems1 + ", "  + chkboxItems2);
        }
        
        Thread.sleep(3000);
        driver.close();
	}

}