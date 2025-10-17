package seleniumLearnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class LaunchChrome {
	
	public static void main(String[] args) {
		// No system property for chromedriver.exe is needed.
        // Selenium Manager automatically finds and downloads the correct driver.
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver_path");
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		//get into the url
		driver.get("http://www.google.com");
		
		//Get the title of the web application
		String title = driver.getTitle();
		System.out.println(title);
		
		
		//To maximize the browser
		driver.manage().window().maximize();
		
	}

}
