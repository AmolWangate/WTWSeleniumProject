package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.utils.RandomUtils;

/**
 * @author Amol Wangate
 * @summary This class provides a method to complete the order placement process.
 *          It uses the ProductsPageHelper to handle adding products to the cart
 *          and then proceeds through the checkout process to finalize the
 *          order.
 */
public class PlaceOrderHelper {

	private WebDriver driver;

	public PlaceOrderHelper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean placeOrder(String username, String password, String productName) {
		return new ProductsPageHelper(driver)
				.addAProductToCart(username, password, productName)
				.clickCartIcon()
				.clickCheckoutBtn()
				.sendFirstName(RandomUtils.getFirstName())
				.sendLastName(RandomUtils.getLastName())
				.sendPostalCode(RandomUtils.getZipCode())
				.clickContinueBtn()
				.clickFinishBtn()
				.isOrderCompletedMessageDisplayed();
	}
}
