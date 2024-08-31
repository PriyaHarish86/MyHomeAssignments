package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecifiedMethodForHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksImplementation extends ProjectSpecifiedMethodForHooks {

	@Before
	public void preCondition() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter Username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
	    // Enter password
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
	    // Click on Login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	    // Click on CRM/SFA link
		driver.findElement(By.xpath("//a[contains(text(),' CRM')]")).click();
		// Click on Accounts tab
		driver.findElement(By.xpath("//div[@class='x-panel-header']//a[contains(text(),'Account')]")).click();
	}
	
	@After
	public void postCondition(){
		driver.close();
	}
}
