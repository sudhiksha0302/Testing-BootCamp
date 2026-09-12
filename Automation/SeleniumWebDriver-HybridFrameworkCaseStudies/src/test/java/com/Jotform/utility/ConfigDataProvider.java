package com.Jotform.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {

        try {

            File src = new File(
                    "./ConfigurationFiles/jotform-config.properties"
            );

            FileInputStream fis = new FileInputStream(src);

            pro = new Properties();

            pro.load(fis);

        } catch (Exception e) {

            System.out.println(
                    "Exception is: " + e.getMessage()
            );

        }

    }

    public String getBrowser() {

        return pro.getProperty("Browser");

    }

    public String getAppURL() {

        return pro.getProperty("AppUrl");

    }

}