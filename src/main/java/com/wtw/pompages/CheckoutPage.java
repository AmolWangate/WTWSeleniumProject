package com.wtw.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.utils.DriverUtilites;

/**
 * @author Amol Wangate
 * @summary POM class for storing all locators from Checkout page. It provides
 *          methods to interact with elements on the checkout page
 */
public class CheckoutPage {

	@FindBy(id = "first-name")
	private WebElement inputFirstName;

	@FindBy(id = "last-name")
	private WebElement inputLastName;

	@FindBy(id = "postal-code")
	private WebElement inputPostalCode;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(xpath = "//div[@data-test='subtotal-label']")
	private WebElement textItemTotal;

	@FindBy(xpath = "//button[@id='finish']")
	private WebElement btnFinish;

	@FindBy(xpath = "//div[@data-test='complete-text']")
	private WebElement textCompleteOrder;

	@FindBy(xpath = "//h2[@data-test='complete-header']")
	private WebElement textThankYou;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public CheckoutPage sendFirstName(String firstName) {
		DriverUtilites.sendKeys(inputFirstName, WaitType.VISIBLE, firstName, "First name");
		return this;
	}

	public CheckoutPage sendLastName(String userName) {
		DriverUtilites.sendKeys(inputLastName, WaitType.VISIBLE, userName, "Last name");
		return this;
	}

	public CheckoutPage sendPostalCode(String userName) {
		DriverUtilites.sendKeys(inputPostalCode, WaitType.VISIBLE, userName, "Postal code");
		return this;
	}

	public CheckoutPage clickContinueBtn() {
		DriverUtilites.click(btnContinue, WaitType.CLICKABLE, "Continue button");
		return this;
	}

	public CheckoutPage clickFinishBtn() {
		DriverUtilites.scrollToElement(btnFinish);
		DriverUtilites.click(btnFinish, WaitType.CLICKABLE, "Finish button");
		return this;
	}

	public boolean isOrderCompletedMessageDisplayed() {
		return DriverUtilites.isDisplayed(textCompleteOrder, WaitType.VISIBLE, "Order complete message");
	}

	public String getItemTotalOnCheckout() {
		return DriverUtilites.getText(textItemTotal, WaitType.VISIBLE, "Item total").split(":")[1].trim();
	}

	public String getThankYouText() {
		return DriverUtilites.getText(textThankYou, WaitType.VISIBLE, "Thank you text");
	}

}
