package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.pompages.ProductsPage;

/**
 * @author Amol Wangate
 * @summary The `this class provides methods to perform actions related to
 *          products, such as adding a product to the cart. It uses LoginHelper
 *          to handle the login process and then interacts with the ProductsPage
 *          to perform the necessary actions.
 */
public class ProductsPageHelper {

	private WebDriver driver;

	public ProductsPageHelper(WebDriver driver) {
		this.driver = driver;
	}

	public ProductsPage addAProductToCart(String username, String password, String productName) {
		return new LoginHelper(driver)
				.login(username, password)
				.clickOnAddToCartBtn(productName);

	}
}
