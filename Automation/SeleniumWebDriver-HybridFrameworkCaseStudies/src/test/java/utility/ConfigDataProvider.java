package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider() {
		File src = new File("./ConfigurationFiles/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load excel file " + e.getMessage());
			
		}
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getAppURL() {
		return pro.getProperty("AppUrl");
	}

}
