package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AltroMutual {
	
	public static void main(String[] args) throws Exception{
		
		WebDriver driver;
		String baseURl="http://altoro.testfire.net/login.jsp";
		driver=new EdgeDriver();
		driver.navigate().to(baseURl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		
		
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No.of links:"+allLinks.size());
	}
}