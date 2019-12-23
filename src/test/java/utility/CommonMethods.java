package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BaseClass;


public class CommonMethods extends BaseClass{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonMethods.class);
	private WebDriverWait wait;
	
	
	public void openURL(String url) {
		driver.get(url);
	}
	
	public void closeDriver() {
		driver.quit();
	}

	public void click(WebElement we) throws Exception {
		try {
			LOGGER.info("locator information used to find the element to be  clicked " + we.toString());
			we.click();
		} catch (Exception ex) {
			LOGGER.error("Exception occured while clicking the element \n" + ex);
			throw ex;
		}

	}

	public void sendKeys(WebElement we, String text) {
		try {
			LOGGER.info("locator information used to find the element to be typed into " + we.toString());
			LOGGER.info("The value of the text " + text);
			we.sendKeys(text);

		} catch (Exception ex) {
			LOGGER.error("Exception occured while typing text \n" + ex);
		}

	}

	public boolean isElementPresent(WebElement we) {
		
		if (we!=null) {
			LOGGER.info("Element: " + we.toString() +" is present");
			return true;
		} else {
			LOGGER.info("Element: " + we.toString() +" is not present");
			return false;
		}
	}
	
	public void clickEnter(By clickingElement) {
		driver.findElement(clickingElement).sendKeys(Keys.ENTER);
	}

	public void clickUsingAynchronousJavaScript(String elementToClick, WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(elementToClick));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
	}

	public void clickUsingJavaScript(String elementToClick) {
		WebElement element = driver.findElement(By.xpath(elementToClick));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickUsingAynchronousJavaScript(String elementToClick) {
		WebElement element = driver.findElement(By.xpath(elementToClick));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
	}

	public void clickUsingJavaScript(By elementToClick) {
		WebElement element = driver.findElement(elementToClick);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("var elem=arguments[0];", element);
	}

	public void doubleClick(By elementLocator) {
		Actions click = new Actions(driver);
		WebElement elementToClick = driver.findElement(elementLocator);
		click.moveToElement(elementToClick);
		click.doubleClick();
		click.build().perform();
	}

	public void enterTextUsingActionClass(String textToBeEntered, By elementLocator) {
		Actions click = new Actions(driver);
		WebElement elementToClick = driver.findElement(elementLocator);
		click.moveToElement(elementToClick);
		click.doubleClick();
		click.sendKeys(textToBeEntered);
		click.build().perform();
	}
	
	public void switchTab() {
		List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	public void switchTodefaultTab() {
		driver.switchTo().defaultContent();
	}
}
