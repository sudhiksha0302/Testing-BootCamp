package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {
	public static void main(String[] args) throws Exception{

		WebDriver driver;
		String baseURl="https://www.saucedemo.com/";
		driver=new EdgeDriver();
		driver.navigate().to(baseURl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		//how to copy XPath from developer tool
		//*[@id="submit"]
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No.of links:"+allLinks.size());
	}

}