package seleniumLearnings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDropdown {

	public static void main(String[] args){

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com");

		WebElement countryDropdown = driver.findElement(By.id("country"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", countryDropdown);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
		countryDropdown.click();

	

		Select countrySelect = new Select(countryDropdown);
		
		//Get all options 
		
		List<WebElement> countryList = countrySelect.getOptions();
		
		for(WebElement country: countryList) {
			System.out.println(country.getText());
		}

		// Select by Value
		countrySelect.selectByValue("india");
//		Thread.sleep(1000); 
		//Select by Visible Text
		countrySelect.selectByVisibleText(" Japan ");
//		Thread.sleep(1000);
		
		//Select by index
		countrySelect.selectByIndex(3);
//		Thread.sleep(1000);
		
		
		//If we do not have select tag in HTML DOM then we have to use either xpath to locate that element and click on it / or we need to use Action class
		driver.close();
		
		driver.quit();
		
		/***
		 * driver.close();
		 * 
		 * driver.get("https://testautomationpractice.blogspot.com");
		 * It will give org.openqa.selenium.NoSuchSessionException: invalid session id
		 * driver.quit();
		 * 
		 * Vice-versa of this will give similar exception
		 * org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		 ***/
	}

}
