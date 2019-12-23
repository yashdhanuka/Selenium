package steps;

import pages.BaseClass;
import pages.Home;

public class HomeSteps extends BaseClass{

	Home home = new Home(driver);
	
	public void clickBestSellerLink() throws Exception {
		home.clickBestSellerLink();
	}
	
	public void clickAmazonpayLink() throws Exception {
		home.clickAmazonpayLink();
	}
	
	public void clickMobileRechargeLink() throws Exception {
		home.clickMobileRechargeLink();
	}
	
	public void clickBestSellingItem() throws Exception{
		home.clickBestSellingItem();
	}
	
	public boolean verifyItemIsBestSelling() {
		return home.verifyItemIsBestSelling();
	}
	
	public boolean verifyMobileRecharge() {
		return home.verifyMobileRecharge();
	}
	
}
