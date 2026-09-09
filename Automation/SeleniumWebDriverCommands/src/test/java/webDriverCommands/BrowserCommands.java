
package webDriverCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCommands {

    @Test(priority = 1)
    public void ChromeBrowserTest() {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println(BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println(BrowserURL);

        driver.quit();
    }

    @Test(priority = 2)
    public void EdgeBrowserTest() {

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println(BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println(BrowserURL);

        driver.quit();
    }

    @Test(priority = 3)
    public void FirefoxBrowserTest() {

        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

        String BrowserTitle = driver.getTitle();
        System.out.println(BrowserTitle);

        String BrowserURL = driver.getCurrentUrl();
        System.out.println(BrowserURL);

        driver.quit();
    }
}

