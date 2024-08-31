package week6.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		//Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver();
		//Maximize the browser window
		driver.manage().window().maximize();
		//Load the URL (https://erail.in/
		driver.get("https://erail.in/");
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		//Enter "MAS" as the "From" station
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		element.clear();
		element.sendKeys("MAS", Keys.ENTER);
		
		//Enter "MDU" as the "To" station
		WebElement element1 = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		element1.clear();
		element1.sendKeys("MDU", Keys.ENTER);
				
		//Uncheck the "Sort on Date" checkbox
		driver.findElement(By.xpath("//input[@checked='checked']")).click();
		Thread.sleep(3000);
		
		//Retrieve the value of 4th row and 2nd col in the table
		String text = driver.findElement(By.xpath("//div[@id='divTrainsList']//table/tbody/tr[5]/td[2]")).getText();
		System.out.println("The value of 4th row and 2nd col in the table is: " +text);
		
		
		//To get the row count in the webtable
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='divTrainsList']//table/tbody/tr"));
		int rowCount = rows.size()-6;
		System.out.println("Total number of rows in the webtable is: " +rowCount);
				
		//To retrieve the train names from the web table
		System.out.println("The train names in the table are: ");
		for(int i=2; i<=rowCount; i++) {
			String text2 = driver.findElement(By.xpath("//div[@id='divTrainsList']//table/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(text2);
	       }
		
		//Verify if there are any duplicate train names in the web table
		// List to store the values of the specific column
		List<String> columnValues = new ArrayList<>();
		int columnIndex = 0; 
			// Extract values from the specific column
			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.xpath("//div[@id='divTrainsList']//table/tbody/tr/td[2]"));
					if (cells.size() > columnIndex) {
						String columnValue = cells.get(columnIndex).getText();
						columnIndex++;
						columnValues.add(columnValue);
						//System.out.println(columnValues);
					}
			}
			// Set to store duplicate values
		    Set<String> duplicates = new HashSet<>();
		    Set<String> uniqueValues = new HashSet<>();
		    
		    // Find duplicates
		    for (String value : columnValues) {
		    	if (!uniqueValues.add(value)) {
		    		duplicates.add(value);
		    	}
		    }
	
		    // Print duplicate values
		    if (!duplicates.isEmpty()) {
		    	System.out.println("Duplicate values found: " + duplicates);
		    	} else {
		    		System.out.println("No duplicate values found.");
		    }
		driver.close();
	}
}