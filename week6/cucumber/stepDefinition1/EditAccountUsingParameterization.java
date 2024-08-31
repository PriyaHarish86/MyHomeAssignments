package stepDefinition1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditAccountUsingParameterization {
	
	public ChromeDriver driver;
	public Actions action;
	public String phone;
	
	@Given("Launch the browser and load the URL")
	public void launch_the_browser_and_load_the_url() {
		//Ignore Notifications
		ChromeOptions cp=new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		
		//Maximize the browser
		driver.manage().window().maximize();
		//Load the URL
		driver.get("https://login.salesforce.com/");
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
	
	@When("Click View All")
	public void click_view_all() {
		//Click View All 
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	}
	
	@When("Click Accounts from App Launcher")
	public void click_accounts_from_app_launcher() throws InterruptedException {
		//Click Accounts from App Launcher
		WebElement ele=driver.findElement(By.xpath("//p[text()='Accounts']"));
		action = new Actions(driver);
		action.scrollToElement(ele).perform();
		ele.click();
		Thread.sleep(5000);
	}	    
	
	@When("Search for the account as {string}")
	public void search_for_the_account_as(String AcctName) throws InterruptedException {
		//Search for the account name by entering unique name
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(AcctName, Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@When("Click the dropdown icon next to the account and select Edit")
	public void click_the_dropdown_icon_next_to_the_account_and_select_edit() throws InterruptedException {
		//Click on the dropdown icon next to account and selct Edit link
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);
	}
	
	@When("Select Type as Technology Partner")
	public void select_type_as_technology_partner() {
		//Select Type field as "Technology Partner"
		driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox__form-element slds-input-has-icon')]//button)[2]")).click();
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
	}
	
	@When("Select Industry as Healthcare")
	public void select_industry_as_healthcare() throws InterruptedException {
	    //Select Industry field as "Healthcare"
		WebElement js = driver.findElement(By.xpath("//label[text()='Industry']/ancestor::records-record-picklist[@slot='inputField']//*[local-name()='button']"));
		driver.executeScript("arguments[0].click();", js);
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.xpath("//span[text()='Healthcare']"));
		action = new Actions(driver);
		action.scrollToElement(ele).perform();
		ele.click();
	}
	
	@When("Enter as Billing Address as {string}")
	public void enter_as_billing_address_as(String billadd) {
		//Enter Billing Address by passing parameterized value
		driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control slds-grow')]//textarea[1]")).sendKeys(billadd);
	}
	
	@When("Enter Shipping Address as {string}")
	public void enter_shipping_address_as(String shipadd) {
		//Enter Shipping Address by passing parameterized value
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(shipadd);
	}
	
	@When("Select Customer Priority as Low")
	public void select_customer_priority_as_low() {
		//Select Customer Priority field as "Low"
		driver.findElement(By.xpath("//label[text()='Customer Priority']/ancestor::records-record-picklist//*[local-name()='button']")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
	}
	
	@When("Select SLA as Silver")
	public void select_sla_as_silver() {
		//Select SLA field as "Silver"
		driver.findElement(By.xpath("//label[text()='SLA']/ancestor::records-record-picklist//*[local-name()='button']")).click();
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
	}
	
	
	@When("Select Active as No")
	public void select_active_as_no() throws InterruptedException {
		//To perform Scroll down to the page
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform(); // scroll down
		Thread.sleep(1000);
		//Select Active as "No"
		driver.findElement(By.xpath("//label[text()='Active']/ancestor::records-record-picklist//*[local-name()='button']")).click();
		driver.findElement(By.xpath("//span[text()='No']")).click();
	}
	
	@When("Enter unique number in Phone field {string}")
	public void enter_unique_number_in_phone_field(String phNo) throws InterruptedException {
		//To scroll up to the page
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
		//Enter phone number field as unique parameterized value
		driver.findElement(By.xpath("//label[text()='Phone']/following::input")).sendKeys(phNo);
		Thread.sleep(2000);
		phone=phNo;
	}
	
	@When("Select Upsell Opportunity as No")
	public void select_upsell_opportunity_as_no() throws InterruptedException {
		//Action to perform Scroll down to the page
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform(); // scroll down
		//Select Upsell opportunity field as "No"
		WebElement js=driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/ancestor::records-record-picklist//*[local-name()='button']"));
		driver.executeScript("arguments[0].click();", js);
		driver.findElement(By.xpath("//span[text()='No']")).click();
	}
	
	@When("Click Save")
	public void click_save() throws InterruptedException {
		//Click on save button
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
	}
	
	@Then("Verify phone number")
	public void verify_phone_number() {
		//Verify the phone number is updated correctly or not
		String text = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/td[4]/span/span[1]")).getText();
		if (text.equals(phone)) {
			System.out.println("Phone number is updated successfully");
		}else
		{
			System.out.println("Phone number is not updated");
		}
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
		//Close the browser
	    driver.close();
	}
}