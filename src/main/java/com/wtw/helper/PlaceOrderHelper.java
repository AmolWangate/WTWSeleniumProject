package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.utils.RandomUtils;

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
