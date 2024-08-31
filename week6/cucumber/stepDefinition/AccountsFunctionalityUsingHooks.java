package stepDefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseClass.ProjectSpecifiedMethodForHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsFunctionalityUsingHooks extends ProjectSpecifiedMethodForHooks{
	
	@When("Click Create Account from left pane")
	public void click_create_account_from_left_pane() {
	    // Click on Create Account link from laft panel
		driver.findElement(By.xpath("//a[text()[normalize-space()='Accounts']]/following::a[text()[normalize-space()='Create Account']]")).click();
	}

	@When("Enter account name as {string}")
	public void enter_account_name_as_name(String name) {
	    // Enter account name
		driver.findElement(By.xpath("//span[text()='Account Name']/following::input")).sendKeys(name);
	}

	@When("Select ownership as Corporation")
	public void select_ownership_as_corporation() {
	    // Select Ownership as Corporation
		WebElement element = driver.findElement(By.name("ownershipEnumId"));
		Select select = new Select(element);
		select.selectByVisibleText("Corporation");
	}

	@When("Enter description")
	public void enter_description() {
	    // Enter the description 
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("Selenium Automation Tester");
	}

	@When("Enter site name")
	public void enter_site_name() {
	    // Enter site name 
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("LeafTaps");
	}

	@When("Enter Number of Employees")
	public void enter_number_of_employees() {
	    // Enter value in number of employees
		driver.findElement(By.xpath("//input[@id='numberEmployees']")).sendKeys("10");
	}

	@Then("Click on Create Account button")
	public void click_on_create_account_button() {
	    // Click on Create Account
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
	}
	
	@Then("Verify account creation is successful")
	public void verify_account_creation_is_successful() {
	    // Verify if account is created or not
		String acct = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		if(acct.contains("Priya")) {
			System.out.println("Account is created successfully");
		}else
		{
			System.out.println("Account is not created");
		}
	}

	@When("Click on Find Accounts from left pane")
	public void click_on_find_accounts_from_left_pane() {
	    // Click on Find Account link from laft panel
		driver.findElement(By.linkText("Find Accounts")).click();;
	}

	@When("Enter AccountName as {string}")
	public void enter_accountname_as_name(String name) {
	    // Enter account name
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys(name);
	}
	
	@When("Click on Find Accounts button")
	public void click_on_find_accounts_button() throws InterruptedException {
	    //Click on Find Accounts
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(3000);
	}

	@When("Click on first item in Account list")
	public void click_on_first_item_in_account_list() {
	    // Click on the first result from Account List
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
	}

	@When("Click on Edit button")
	public void click_on_edit_button() {
	    // Click on Edit button
		driver.findElement(By.linkText("Edit")).click();
	}

	@When("Update description")
	public void update_description() {
	    // Update the description
		WebElement desc = driver.findElement(By.xpath("(//textarea[@class='inputBox'])[1]"));
		desc.clear();
		desc.sendKeys("Automation Tester in Selenium Webdriver");
		
	}

	@When("Update Number of Employees")
	public void update_number_of_employees() {
	    // Update the number of Employeess
		WebElement upEmp = driver.findElement(By.xpath("(//span[text()='Number Of Employees']/following::input)[1]"));
		upEmp.clear();
		upEmp.sendKeys("12");
	}

	@Then("Click on Save")
	public void click_on_save() {
	    // Click Save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
	}

	@Then("Verify edit account is successful")
	public void verify_edit_account_is_successful() {
		 // Verify if account is edited or not
		String editacct = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		if(editacct.contains("Priya")) {
			System.out.println("Account details are edited successfully");
		}else
		{
			System.out.println("Account details are not edited");
		}
		
	}
	
	@Then("Click on Deactivate Account button")
	public void click_on_deactivate_account_button() throws InterruptedException {
	    // Click on Deactivate button
		driver.findElement(By.linkText("Deactivate Account")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Then("Verify Delete Account is successful")
	public void verify_delete_account_is_successful() {
	    //Verify if account is deleted or not
		String text = driver.findElement(By.xpath("//span[contains(text(),'This account was deactivated')]")).getText();
		if(text.contains("deactivated")) {
			System.out.println("Account is deleted successfully");
		}else
		{
			System.out.println("Account is not deleted");
		}
	}
}
