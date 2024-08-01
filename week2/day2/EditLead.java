package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("testFN12");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("testLN12");
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("testFNLocal");
		
		//driver.findElement(By.name("departmentName")).sendKeys("test dept");
		WebElement element = driver.findElement(By.name("departmentName"));
		element.sendKeys("test dept");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Creating Leads");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test12@gmail.com");
		
		WebElement selectElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[contains(@value,'te Lead')]")).click();
	
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[contains(text(),'Edit')]")).click();
		
		WebElement element1 =driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']"));
		element1.clear();
		
		driver.findElement(By.name("importantNote")).sendKeys("Creating new leads");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//To return the title of the page using getTitle()
      	String title = driver.getTitle();
      	System.out.println(title);
      		
      	if(title.contains("View Lead ")) {
      		System.out.println("The page title is : " +title);
      	}else
      	{
      		System.out.println("The page title is not : " +title);
      	}
      	
      	driver.close();
	}

}
