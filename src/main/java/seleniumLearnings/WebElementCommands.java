package seleniumLearnings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementCommands {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com");

		WebElement title = driver.findElement(By.xpath("//h1[@class='title']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(title));
		String titleString = title.getText();
		System.out.println(titleString);

		// Getting the list of WebElements with findElements command
		List<WebElement> inputboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));

		// Print the number of input boxes
		System.out.println("Total number of input boxes: " + inputboxes.size());

		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));

		String username = "Kanhaiya Verma";
		String useremail = "kanhaiya123@gmail.com";

		// input value with the sendKeys
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(username);
		Thread.sleep(1000);

		// clear the values in the name input box
		name.clear();
		Thread.sleep(1000);

		name.sendKeys(username);
		Thread.sleep(1000);

		// Simulate Keyboard keys
		name.sendKeys(Keys.COMMAND + "a");
		// name.sendKeys(Keys.CONTROL + "a"); --> For windows
		Thread.sleep(1000);
		name.sendKeys(Keys.DELETE);

		// Check if Element is Present, Displayed, Enabled or Selected
		Thread.sleep(1000);
		// Present
		List<WebElement> listName = driver.findElements(By.xpath("//div[@class='form-group']//label[text()='Days:']"));
		boolean isPresent = !listName.isEmpty();
		System.out.println("Name is Present: " + isPresent);
		Thread.sleep(1000);

		// Displayed
		WebElement femaleLabel = driver.findElement(By.xpath("//label[@for='female']"));
		//Scroll using JavaScriptExecutor with pixels
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement femaleInput = driver.findElement(By.xpath("//label[@for='female']/../input"));
		if (femaleLabel.isDisplayed()) {
			System.out.println("Female Label is Displayed: " + femaleLabel.isDisplayed());
			femaleInput.click();
		} else {
			System.out.println("Female Label is Displayed: " + femaleLabel.isDisplayed());
		}
		Thread.sleep(1000);

		// Enabled
		WebElement submitBtn = driver.findElement(By.className("submit-btn"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",submitBtn);
		if (submitBtn.isEnabled()) {
			System.out.println("Submit button is Enabled: " + submitBtn.isEnabled());
			submitBtn.click();
		} else {
			System.out.println("Submit button is Enabled: " + submitBtn.isEnabled());
		}
		Thread.sleep(1000);

		// Selected
		WebElement SundayInlineInput = driver.findElement(By.xpath("//label[text()='Sunday']/../input"));

		if (SundayInlineInput.isSelected()) {
			System.out.println("Sunday Inline Input is Selected: " + SundayInlineInput.isSelected());
			SundayInlineInput.click();
		} else {
			System.out.println("Sunday Inline Input is Selected: " + SundayInlineInput.isSelected());
		}

		driver.close();
		driver.quit();

	}

}
