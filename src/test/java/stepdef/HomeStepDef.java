package stepdef;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.HomeSteps;

public class HomeStepDef {
	
	HomeSteps hs = new HomeSteps();
	
	@When("we click the best sellers link")
	public void we_click_the_best_sellers_link() throws Exception {
	    hs.clickBestSellerLink();
	}

	@When("we choose the number one seller item")
	public void we_choose_the_number_one_seller_item() throws Exception {
	    hs.clickBestSellingItem();
	}

	@Then("we validate the best seller tag of the item")
	public void we_validate_the_best_seller_tag_of_the_item() {
	    Assert.assertTrue(hs.verifyItemIsBestSelling());
	}

	@When("we click the amazon pay link")
	public void we_click_the_amazon_pay_link() throws Exception {
	    hs.clickAmazonpayLink();
	}

	@When("go to mobile recharge")
	public void go_to_mobile_recharge() throws Exception {
	    hs.clickMobileRechargeLink();
	}

	@Then("I verify the pay link")
	public void i_verify_the_pay_link() {
		Assert.assertTrue(hs.verifyMobileRecharge());
	}

}
