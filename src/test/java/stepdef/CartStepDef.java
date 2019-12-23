package stepdef;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseClass;
import steps.CartSteps;

public class CartStepDef extends BaseClass{
	
	CartSteps cs = new CartSteps();
	

	@When("search for a product {string}")
	public void search_for_a_product(String string) {
		cs.searchForAProduct(string);
	}

	@When("add the product to cart")
	public void add_the_product_to_cart() {
		cs.addTheProductToCart();
	}
	
	@When("we go to to cart and delete the product {string}")
	public void we_go_to_to_cart_and_delete_the_product(String string) {
		cs.deleteProductInCart(string);
	}

	@Then("the product should be removed")
	public void the_product_should_be_removed() throws InterruptedException {
		Assert.assertTrue(cs.verifyDeletedProduct());
	}

	@Then("we should see that product in cart")
	public void we_should_see_that_product_in_cart() {
		Assert.assertTrue(cs.goToCartandVerify());
	}
	
}
