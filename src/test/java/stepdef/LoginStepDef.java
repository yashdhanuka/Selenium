package stepdef;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.LoginSteps;

public class LoginStepDef{
	
	LoginSteps ls = new LoginSteps();
	
	
	
	@Given("we are on login page")
	public void we_are_on_flipkart_login_page() {
	    ls.goToURL();
	}

	@When("we enter credentials")
	public void we_enter_credentials() {
		ls.loginUsingPropertyFileData();
	}
	
	@When("we enter credentials {string} and {string}")
	public void we_enter_credentials_and(String loginname, String pass) {
		ls.loginUsingFeatureFileData(loginname, pass);
	}

	@Then("we should be able to login successfully")
	public void we_should_be_able_to_login_successfully() {
		Assert.assertTrue(ls.isSearchBoxVisible());
	}
	
	
}
