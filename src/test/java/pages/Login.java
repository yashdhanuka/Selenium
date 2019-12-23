package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonMethods;


public class Login extends BaseClass{
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	CommonMethods cm = new CommonMethods();

	@FindBy(id = "nav-link-accountList")
	private WebElement signIn;
	
	@FindBy(id = "ap_email")
	private WebElement username;
	
	@FindBy(id = "ap_password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;
	
	
	public void loginurl(String url) {
		cm.openURL(url);
	}
	
	public void enterCredentialsandLogin(String loginname,String pass) {
		signIn.click();
		username.sendKeys(loginname);
		submit.click();
		password.sendKeys(pass);
		submit.click();
	}
	
	public boolean isSearchBoxVisible() {
		return searchBox.isDisplayed();
	}
}