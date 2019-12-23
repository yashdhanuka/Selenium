package steps;

import pages.BaseClass;
import pages.Cart;
import utility.CommonMethods;

public class CartSteps extends BaseClass{

	Cart cart = new Cart(driver);
	CommonMethods cm = new CommonMethods();
	
	public void searchForAProduct(String product) {
		cart.searchForAProduct(product);
	}
	
	public void addTheProductToCart() {
		cart.addTheProductToCart();
	}
	
	public boolean goToCartandVerify() {
		cart.goToCart();
		return cart.VerifyProductInCart();
	}
	
	public void deleteProductInCart(String product) {
		cart.goToCart();
		cart.deleteProductInCart(product);
	}
	
	public boolean verifyDeletedProduct() throws InterruptedException {
		return cart.verifyProductDeleted();
	}
	
	public void closeBrowser() {
		cm.closeDriver();
	}
	
}
