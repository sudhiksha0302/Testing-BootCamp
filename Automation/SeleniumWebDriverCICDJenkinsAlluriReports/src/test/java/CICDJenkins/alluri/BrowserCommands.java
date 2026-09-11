package CICDJenkins.alluri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCommands {
	@Test(priority = 0)
	public void ChromeBrowserTest1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 1)
	public void FirefoxBrowserTest1() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 2)
	public void EdgeBrowserTest1() {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 3)
	public void ChromeBrowserTest2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 4)
	public void FirefoxBrowserTest2() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.github.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 5)
	public void EdgeBrowserTest2() {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 6)
	public void ChromeBrowserTest3() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 7)
	public void FirefoxBrowserTest3() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.microsoft.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 8)
	public void EdgeBrowserTest3() {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.apple.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 9)
	public void ChromeBrowserTest4() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}

	@Test(priority = 10)
	public void FirefoxBrowserTest4() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.apple.com/");
		driver.manage().window().maximize();
		System.out.println("Browser Title: " + driver.getTitle());
		System.out.println("Browser URL: " + driver.getCurrentUrl());
		driver.quit();
	}
}