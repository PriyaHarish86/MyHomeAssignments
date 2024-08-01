package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

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
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[contains(text(),'Create')]")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestCompany");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("testFN");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("testLN");
		driver.findElement(By.xpath("//input[contains(@id,'generalProfTitle')]")).sendKeys("TestTitle");
		driver.findElement(By.xpath("//input[contains(@value,'te Lead')]")).click();
		
		//To return the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("CRM")) {
			System.out.println("The browser title is : " +title);
		}else
		{
			System.out.println("The browser title is not : " +title);
		}
		
		//get text from web application
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("The first name is " +text);
				
		if(text.contains("testFN")) {
			System.out.println("Lead created successfully : " +text);
		}else {
			System.out.println("Lead not created : " +text);
		}
		
		driver.close();
	}

}
