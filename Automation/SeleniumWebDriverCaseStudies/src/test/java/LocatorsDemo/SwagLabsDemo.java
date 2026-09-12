package LocatorsDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsDemo {

	public static void main(String[] args) throws Exception {
		  WebDriver driver = new ChromeDriver();
	        driver.get("https://swaglabs.in/");
	        driver.manage().window().maximize();
	        Thread.sleep(10000);
	        
	        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	        System.out.println(allLinks.size());

	        for (WebElement ele : allLinks) {
	            System.out.println(ele.isDisplayed());
	            System.out.println(ele.isEnabled());
	            System.out.println(ele.getAttribute("href"));
	        }

	        // Click on 4th link
	        WebElement ele = allLinks.get(3);
	        ele.click();


	}

}
