package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFcatory {

    public static WebDriver startBrowser(String browser) {

        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else {

            System.out.println("Sorry, we do not support this browser");
        }

        if (driver != null) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeBrowser(WebDriver driver) {

        if (driver != null) {
            driver.quit();
        }
    }
}