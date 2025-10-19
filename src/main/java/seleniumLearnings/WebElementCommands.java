package seleniumLearnings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebElementCommands {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement title = driver.findElement(By.xpath("//h1[@class='title']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOf(title));
		String titleString = title.getText();
		System.out.println(titleString);
		
		WebElements inputBox = driver.findElements(By.xpath("//input[@class='form-check-input']"));
		
		driver.close();
		driver.quit();

	}

}
