package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkTextOrPartialLinkTextDemo {
	WebDriver driver;
	

	@BeforeTest
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/");
		Thread.sleep(10000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Cookie popup not displayed.");

		}
	}
	@Test
	public void linkTest() {
		driver.findElement(By.partialLinkText("Vitamins")).click();
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int nolinks=links.size();
		System.out.println("Number of Links in hollandandbarrett application: " + nolinks);
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
			String str=links.get(i).getText();
			String str1="Vitamins";
			if (str==str1) {
				driver.findElement(By.linkText("Vitamins")).click();
				driver.findElement(By.xpath("(//a[contains(@type,'button')])[4]")).click();
			}
		}
	}
	@AfterTest
	public void teardown() {
		driver.quit();
}
}
