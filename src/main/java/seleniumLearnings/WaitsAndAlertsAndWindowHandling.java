package seleniumLearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsAndAlertsAndWindowHandling {

	public static void main(String[] args) {
		/*** Types of Waits
		 * 1. Implicit Wait -> global for every element
		 * 2. Explicit Wait -> for particular element wait for a specific condition to met
		 * 3. Fluent Wait -> for particular element wait for a specific condition to met with a custom polling frequency and ignore Exception
		 * ***/
		
		WebDriver driver = new ChromeDriver();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com");
		
		//ExplicitWait
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement title = driver.findElement(By.className("title"));
		
		wait.until(ExpectedConditions.visibilityOf(title));
		
		driver.close();
		driver.quit();

	}

}
