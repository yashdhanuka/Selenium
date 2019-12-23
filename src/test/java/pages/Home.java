package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonMethods;

public class Home extends BaseClass{

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	CommonMethods cm = new CommonMethods();
	boolean tag = false;
	
	@FindBy(xpath = "//a[text()='Best Sellers']")
	private WebElement bestSeller;
	
	@FindBy(xpath = "//a[text()='Amazon Pay']")
	private WebElement amazonPay;
	
	@FindBy(xpath = "//span[text()='Mobile Recharge']")
	private WebElement mobileRecharge;
	
	@FindBy(xpath = "//a[@class='a-link-normal']")
	private WebElement bestSellingItem;
	
	@FindBy(xpath = "//i[@class='a-icon a-icon-addon p13n-best-seller-badge']")
	private WebElement NumberOneTag;
	
	@FindBy(id = "payButtonText")
	private WebElement pay;
	
	
	public void clickBestSellerLink() throws Exception {
		cm.click(bestSeller);
	}
	
	public void clickAmazonpayLink() throws Exception {
		cm.click(amazonPay);
	}
	
	public void clickMobileRechargeLink() throws Exception {
		cm.click(mobileRecharge);
	}
	
	public void clickBestSellingItem() throws Exception{
		cm.click(bestSellingItem);
	}
	
	public boolean verifyItemIsBestSelling() {
		if(NumberOneTag.getText().contains("1"))
			tag = true;
		return tag;
	}
	
	public boolean verifyMobileRecharge() {
		if(pay.getText().contains("Pay"))
			tag = true;
		return tag;
	}
}
