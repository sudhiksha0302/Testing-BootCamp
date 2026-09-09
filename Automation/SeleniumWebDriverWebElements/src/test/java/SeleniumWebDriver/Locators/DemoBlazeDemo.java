package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeDemo {
	

	public static void main(String[] args) throws Exception{
		
		WebDriver driver;
		String baseURl="https://www.demoblaze.com/";
		driver=new ChromeDriver();
		driver.navigate().to(baseURl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		
		
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
	}

}