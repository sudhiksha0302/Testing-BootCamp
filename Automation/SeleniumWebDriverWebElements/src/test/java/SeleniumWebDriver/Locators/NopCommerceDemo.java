package SeleniumWebDriver.Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NopCommerceDemo {
	
    public static void main(String[] args) throws Exception{
		
		WebDriver driver;
		String baseURl="https://www.nopcommerce.com/en?srsltid=AfmBOop5n80t6gfM0KOoLKarxvf4JxDa4pU-G6DKpAfEOE__8R9Odp82";
		driver=new ChromeDriver();
		driver.navigate().to(baseURl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		
		//driver.findElement(By.xpath("//*[@id=\"lVJB5\"]/div/label/span[1]")).click();
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
	}

}