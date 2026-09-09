package DDTCsvFile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import utility.Helper;

public class CSVFileReading {
	String CsvPath="C:\CSV File Reading\Sample file.xlsx";
	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception{
		driver=Helper.startBrowser("Chrome");
		driver.get("https://only-testing-blog.blogspot.com/2014/05/form.html");
		driver.manage().window().maximize();
	}

}
