package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	public ChromeDriver driver;
	
	@Given("Launch the browser and load the URL")
	public void launch_the_browser_and_load_the_url() {
		//Ignore Notifications
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		
		//Load the URL
		driver.get("https://login.salesforce.com/");
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximize the browser
		driver.manage().window().maximize();
	}

	@When("Enter Username as {string}")
	public void enter_username_as(String userName) {
		//Enter UserName
		driver.findElement(By.id("username")).sendKeys(userName);
	}

	@When("Enter Password as {string}")
	public void enter_password_as(String pwd) {
		//Enter Password
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@Then("Click on Login button")
	public void click_on_login_button() {
		//Click on Login
		driver.findElement(By.id("Login")).click();
	}
	
	@When("Click on toggle menu button from left corner")
	public void click_on_toggle_menu_button_from_left_corner() {
		//Click on the toggle menu button from left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@When("Click view All")
	public void click_view_all() {
		//Click View All 
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	}

	@When("Click Legal Entities from App Launcher")
	public void click_legal_entities_from_app_launcher() throws InterruptedException {
		//Click Legal Entities from App Launcher
		WebElement ele=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions opt=new Actions(driver);
		opt.scrollToElement(ele).perform();
		ele.click();
		Thread.sleep(3000);
	}

	@When("Click on Accounts dropdown")
	public void click_on_accounts_dropdown() {
		//Click on Accounts tab
		driver.findElement(By.xpath("(//*[local-name()='svg' and @data-key='chevrondown'])[5]")).click();
		
	}

	@When("Click on New Account button")
	public void click_on_new_account_button() {
		//Click on New Account
		WebElement js = driver.findElement(By.xpath("//span[text()='New Account']"));
		driver.executeScript("arguments[0].click();", js);
	}

	@When("Enter account name as {string}")
	public void enter_account_name_as_name(String name) {
	    //Enter 'your name' as account name
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(name);
	}

	@When("Select ownership as Public")
	public void select_ownership_as_public() {
		//Select Ownership as Public
	    driver.findElement(By.xpath("(//span[text()='--None--'])[3]")).click();
	    driver.findElement(By.xpath("//span[text()='Public']")).click();
	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		//Click on Save button
	  driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
	  Thread.sleep(3000);
	}

	@Then("Verify Account name is created")
	public void verify_account_name_is_created() {
		//Verify account name
		String text = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
		if(text.contains("Priya")) {
			System.out.println("The account is created successfully");
		}else
		{
			System.out.println("The account is not created");
		}
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		//Close the browser
		driver.close();
	}
}
