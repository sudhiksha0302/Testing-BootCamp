package webDriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigationCommands {
	WebDriver driver;

	@Test(priority = 1)
	public void NavigateDemo() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.apple.com/");
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.navigate().to("https://login.yahoo.com/");
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 2)
	public void NavigateForward() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.apple.com/");
		driver.navigate().to("https://login.yahoo.com/");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		System.out.println("Forward URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 3)
	public void NavigateBackward() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.apple.com/");
		driver.navigate().to("https://login.yahoo.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Backward URL: " + driver.getCurrentUrl());
		driver.quit();
	}
}