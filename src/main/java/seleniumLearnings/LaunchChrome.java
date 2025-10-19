package seleniumLearnings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
public class LaunchChrome {

	public static void main(String[] args) {
		/***
		 * No system property for chromedriver.exe is needed. Selenium Manager
		 * automatically finds and downloads the correct driver.
		 * 
		 * System.setProperty("webdriver.chrome.driver", "chromedriver_path");
		 ***/

		WebDriver driver = new ChromeDriver();

		// WebDriver driver = new FirefoxDriver();

		// get into the url
		driver.get("http://www.amazon.com"); // get belongs to WebDriver Interface

		// To maximize the browser
		driver.manage().window().maximize();

		// Get the title of the web application
		String title = driver.getTitle();
		System.out.println(title);

		// Ways to Refresh a page in Selenium
		// 1. Using Navigation interface
		driver.navigate().refresh(); // cleanest and reliable with W3C-compliant

		// 2.Using get again
		driver.get(driver.getCurrentUrl());

		// 3.Using JavaScript
		((JavascriptExecutor) driver).executeScript("location.reload()");

		// To Open New tab and open other url to that new tab
		// driver.switchTo().newWindow(WindowType.TAB);

		driver.navigate().to("https://www.flipkart.com"); // belongs to Navigation Interface

		// Navigate Forward and Backward
		// 1. Go back to Amazon page
		driver.navigate().back(); // This is usually wait until page loaded , but its very slow then we have to
									// add explicit wait

		// 2. Go forward to Flipkart Page
		driver.navigate().forward();

		// Get the title of the web application
		String title2 = driver.getTitle();
		System.out.println(title2);

		/***
		 * Another way of Navigating to a specific Page
		 * Using JavaScript Redirection
		 * Using Element Click
		 * Using form Submission
		 ***/
		((JavascriptExecutor)driver).executeScript("window.location='https://examples.com'");
		

		driver.close();
		driver.quit();
	}

}
