package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utility.PropertyManager;

public class BaseClass {

	protected static Properties properties = PropertyManager.loadApplicationProperty();
	protected static WebDriver driver;
	
	public static String getReportConfigPath(){
		 String reportConfigPath = properties.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		}
	
	
}
