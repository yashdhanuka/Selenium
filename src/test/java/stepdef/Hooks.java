package stepdef;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BaseClass;

public class Hooks extends BaseClass{

	@Before
	public void initializeDriver() {
		String path = properties.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	@After
	public void closeDriver() {
		driver.quit();
	}
	
}
