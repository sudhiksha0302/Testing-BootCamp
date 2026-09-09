package SeleniumWebDriver.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassNameDemo {
	@Test
	public void TestDemo() throws Exception {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/");

	    Thread.sleep(10000);
	    try {
	        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    } catch (Exception e) {
	        System.out.println("Cookie popup not displayed.");
	    }

	    driver.findElement(By.xpath("//a[@aria-label='Link to Vitamin Drinks category']")).click();
	    driver.findElement(By.className("ProductCardImage-module_picture__4Wo-o")).click();

	    String BrowserTitle = driver.getCurrentUrl();
	    System.out.println(BrowserTitle);

	    driver.navigate().back();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println(BrowserTitle);

	    driver.navigate().refresh();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println(BrowserTitle);

	    driver.navigate().forward();
	    BrowserTitle = driver.getCurrentUrl();
	    System.out.println(BrowserTitle);
	}
}
