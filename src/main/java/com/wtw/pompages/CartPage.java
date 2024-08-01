package com.wtw.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.utils.DriverUtilites;
import com.wtw.utils.DynamicXpathUtil;

/**
 * @author Amol Wangate
 * @summary POM class for storing all locators from Cart page. It provides
 *          methods to interact with elements on the Cart page
 */
public class CartPage {

	@FindBy(id = "checkout")
	private WebElement btnCheckout;

	String textProductPrice = "//div[contains(.,'%s')]/ancestor::div[@class='cart_item_label']//div[@data-test='inventory-item-price']";
	String btnRemoveCartPage = "//div[contains(.,'%s')]/ancestor::div[@class='cart_item_label']//button[contains(.,'Remove')]";
	String textProductQuantity = "//div[contains(.,'%s')]/ancestor::div[@data-test='inventory-item']/div[@data-test='item-quantity']";

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CheckoutPage clickCheckoutBtn() {
		DriverUtilites.click(btnCheckout, WaitType.CLICKABLE, "Check out button");
		return new CheckoutPage(driver);
	}

	public String getProductPriceOnCartPage(String productName) {
		WebElement priceElement = DynamicXpathUtil.getDynamicXpath(textProductPrice, productName);
		DriverUtilites.scrollToElement(priceElement);
		return DriverUtilites.getText(priceElement, WaitType.CLICKABLE,
				"Product price on cart page for " + productName);
	}

	public void clickRemoveBtnOnCartPage(String productName) {
		WebElement priceElement = DynamicXpathUtil.getDynamicXpath(btnRemoveCartPage, productName);
		DriverUtilites.scrollToElement(priceElement);
		DriverUtilites.click(priceElement, WaitType.CLICKABLE, "Remove button on cart page for " + productName);
	}

	public String getProductQuantity(String productName) {
		WebElement priceElement = DynamicXpathUtil.getDynamicXpath(textProductQuantity, productName);
		DriverUtilites.scrollToElement(priceElement);
		return DriverUtilites.getText(priceElement, WaitType.CLICKABLE,
				"Product quantity on cart page for " + productName);
	}
}
