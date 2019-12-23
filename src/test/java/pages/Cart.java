package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.CommonMethods;

public class Cart extends BaseClass{

	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	String productName = null;
	boolean productAvailable = false;
	boolean productdeleted = false;
	CommonMethods cm = new CommonMethods();
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> products;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCart;
	
	@FindBy(id = "nav-cart")
	private WebElement cart;
	
	@FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']")
	private List<WebElement> productsInCart;
	
//"//input[contains(@aria-label,'Samsung Galaxy A50s') and @value = 'Delete']"
	
	@FindBy(xpath = "//div[@data-action='delete']")
	private WebElement deletedProduct;
	
	
	public void searchForAProduct(String product) {
		productName = product;
		searchBox.sendKeys(Keys.chord(product,Keys.ENTER));	
	}
	
	public void addTheProductToCart() {
		for(WebElement product : products) {
			String getName = product.getText();
			if(getName.contains(productName)) {
				product.click();
				break;
			}
		}
		cm.switchTab();
		addToCart.click();
		cm.switchTodefaultTab();
	}
	
	public void goToCart() {
		cart.click();
	}
	
	public boolean VerifyProductInCart() {
		for(WebElement product : productsInCart) {
			String getName = product.getText();
			if(getName.contains(productName)) {
				productAvailable =  true;
			}
		}
		return productAvailable;
	}
	
	public void deleteProductInCart(String product) {
		productName = product;
		String element = "//input[contains(@aria-label, '" + product + "') and @value = 'Delete']";
		WebElement delete = driver.findElement(By.xpath(element));
		delete.click();
	}
	
	public boolean verifyProductDeleted() throws InterruptedException {
		Thread.sleep(1000);
		String productDetail = deletedProduct.getText();
		if(productDetail.contains(productName)) {
			productdeleted = true; 
		}
		return productdeleted;
	}
}
