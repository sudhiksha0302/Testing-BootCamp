package com.Jotform.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

    public static void capturedScreenShot(
            WebDriver driver) {

        try {

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(
                            OutputType.FILE
                    );

            File destination =
                    new File(
                            "./ScreenShots/Jotform_"
                                    + getCurrentDateTime()
                                    + ".png"
                    );

            FileUtils.copyFile(
                    source,
                    destination
            );

            System.out.println(
                    "Captured ScreenShot-On Failure"
            );

        }

        catch (Exception e) {

            System.out.println(
                    "Exception While Taking Screen Shot "
                            + e.getMessage()
            );

        }

    }

    private static String getCurrentDateTime() {

        DateFormat customFormat =
                new SimpleDateFormat(
                        "MM_dd_yyyy_HH_mm_ss"
                );

        Date currentdate = new Date();

        return customFormat.format(currentdate);

    }

}