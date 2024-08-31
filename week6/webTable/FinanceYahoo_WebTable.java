package week6.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo_WebTable {

	public static void main(String[] args) {
		//Intialize driver
		ChromeDriver driver=new ChromeDriver();
		//Maximize the browser
		driver.manage().window().maximize();
		//Load the URL
		driver.get("https://finance.yahoo.com/");
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on “Crypto” tab
		Actions act = new Actions(driver);
		WebElement mo = driver.findElement(By.xpath("//span[text()='More']"));
		act.moveToElement(mo).perform();
		driver.findElement(By.xpath("//a[@href='https://finance.yahoo.com/crypto/']")).click();
		
		//Locate the cryptocurrency names in the table using specific row.
		//Get row size
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='tableContainer yf-e14xkq']/div/table/tbody/tr"));
		int rowCount = rows.size();
		
		//Locate the cryptocurrency names in the table using specific row and column.
		//Get column size
		List<WebElement> cols = driver.findElements(By.xpath("//div[@class='tableContainer yf-e14xkq']/div/table/tbody/tr[1]/td[1]"));
		int colCount = cols.size();
		
		//To retrieve the cryptocurrency names from the webtable
		System.out.println("The Crypto Currency names in the table are: ");
		for(int i=1; i<=rowCount; i++) {
			for(int j=1; j<=colCount;j++) {
				String text = driver.findElement(By.xpath("//div[@class='tableContainer yf-e14xkq']/div/table/tbody/tr["+i+"]/td["+j+"]//span[contains(text(),'-USD')]")).getText();
				System.out.println(text);
			}
		}		
		
		driver.close();

	}

}
