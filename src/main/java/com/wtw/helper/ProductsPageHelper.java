package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.pompages.ProductsPage;

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
