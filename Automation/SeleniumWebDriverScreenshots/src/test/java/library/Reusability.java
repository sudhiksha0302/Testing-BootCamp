package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {

	public static void capturedScreensShot(WebDriver driver, String screenShotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./ScreenShots/"+screenShotName+".png"));
			System.out.println("captured screenshot by Selenium WebDriver");
		}
		catch (Exception e) {
			System.out.println("Exception while taking Screenshot"+e.getMessage());
		}
	}
}