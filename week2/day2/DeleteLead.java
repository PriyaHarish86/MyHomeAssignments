package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),' CRM')]")).click();
		
		driver.findElement(By.xpath("//div[@class='x-panel-header']//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[contains(text(),'Find')]")).click();
		driver.findElement(By.xpath("//span[@class='x-tab-strip-text ']/following::span[(text()='Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("987456321");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("14128")).click();
		//driver.findElement(By.xpath("//a[@class='linktext' and text()='13536']")).click();
		//driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();		
		
		driver.findElement(By.xpath("(//a[@class='subMenuButton']/following-sibling::a)[3]")).click();
		
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[contains(text(),'Find')]")).click();


		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following::input[@name='id']")).sendKeys("14128");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(3000);
		boolean text = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).isDisplayed();
		if(text==true) {
			System.out.println("The record is deleted successfully");
		}
		
		driver.close();
		
		}

}
