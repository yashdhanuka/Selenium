package steps;

import java.io.IOException;

import pages.BaseClass;
import pages.Login;
import utility.ExcelOperations;

public class LoginSteps extends BaseClass{

	Login login = new Login(driver);
	ExcelOperations excel = new ExcelOperations();
	String username = null;
	String password = null;
	
	public void loginUsingPropertyFileData() {
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		login.enterCredentialsandLogin(username, password);
	}
	
	public void loginUsingExcelData() throws IOException {
		String username = excel.getColumnDataUsingColumnName(properties.getProperty("excelFilePath"), "username").get(0);
		String password = excel.getColumnDataUsingColumnName(properties.getProperty("excelFilePath"), "password").get(0);
		login.enterCredentialsandLogin(username, password);
	}
	
	public void loginUsingFeatureFileData(String username, String password) {
		login.enterCredentialsandLogin(username, password);
	}
	
	public void goToURL() {
		login.loginurl(properties.getProperty("url"));
	}
	
	public boolean isSearchBoxVisible() {
		return login.isSearchBoxVisible();
	}
	
}
