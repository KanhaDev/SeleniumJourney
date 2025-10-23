package seleniumLearnings;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;




public class DataHandling {

	public static void main(String[] args) throws IOException {
		
		//Properties File Import
		Properties prop = new Properties();
		FileInputStream fisProperties = new FileInputStream("src/main/resources/config.properties");
		prop.load(fisProperties);
		String url = prop.getProperty("url");
		System.out.println(url);
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		System.out.println(implicitWait);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.get(url);
		
		
		//Excel File Import
		FileInputStream fisExcel = new FileInputStream("src/main/resources/TestData.xlsx");
		Workbook wb = new XSSFWorkbook(fisExcel);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String username = cell.getStringCellValue();
		System.out.println(username);
		wb.close();
		
		driver.quit();
	}

}
