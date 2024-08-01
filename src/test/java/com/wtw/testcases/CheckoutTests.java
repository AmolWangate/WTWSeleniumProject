package com.wtw.testcases;

import static com.wtw.constants.TestConstants.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wtw.baseclass.BaseClass;
import com.wtw.customannotation.TestAnnotation;
import com.wtw.driverfactory.DriverManager;
import com.wtw.helper.AssertionUtil;
import com.wtw.listeners.TestListeners;
import com.wtw.objectmanager.ObjectManager;
import com.wtw.ownerfactory.PropUtil;
import com.wtw.utils.RandomUtils;

@Listeners(TestListeners.class)
public class CheckoutTests extends BaseClass {

	@TestAnnotation(module = CHECKOUT, user = AMOL)
	@Test(groups = { REGRESSSION }, description = "Multiple scenario workflow - TC03")
	public void multipleScenarioWorkflow() {		
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		String expectedFilterOption = "Price (low to high)";
		String productJacket = "Sauce Labs Fleece Jacket";
		String productOnesie = "Sauce Labs Onesie";

		String actualSelectedFilterOption = manager.getLoginHelper()
				.login(PropUtil.getConfig().validusername(), PropUtil.getConfig().userpassword())
				.selectFilter(expectedFilterOption).getSortFilterSlectedOption();
		AssertionUtil.equals(actualSelectedFilterOption, expectedFilterOption, "sort filter");
		AssertionUtil.isTrue(manager.getProductsPage().arePricesInAsceandingOrder(), "product prices in ascending order");

		manager.getProductsPage().clickOnAddToCartBtn(productJacket);
		manager.getProductsPage().clickOnAddToCartBtn(productOnesie);
		AssertionUtil.isFalse(manager.getProductsPage().isAddToCartButtonDisplayed(productJacket), productJacket + " ATC button");
		AssertionUtil.isFalse(manager.getProductsPage().isAddToCartButtonDisplayed(productOnesie), productOnesie + " ATC button");
		AssertionUtil.isTrue(manager.getProductsPage().isRemoveButtonDisplayed(productJacket), productJacket + " remove button");
		AssertionUtil.isTrue(manager.getProductsPage().isRemoveButtonDisplayed(productOnesie), productOnesie + " remove button");

		String productPagePriceForJacket = manager.getProductsPage().getProductPrice(productJacket);
		String productPagePriceForOnesie = manager.getProductsPage().getProductPrice(productOnesie);
		String cartQuantityBefore = manager.getProductsPage().getCartQuantity();
		AssertionUtil.equals(cartQuantityBefore, String.valueOf(2), "cart quantity");
		manager.getProductsPage().clickCartIcon();
		String cartPagePriceForJacket = manager.getCartPage().getProductPriceOnCartPage(productJacket);
		String cartPagePriceForOnesie = manager.getCartPage().getProductPriceOnCartPage(productOnesie);

		AssertionUtil.equals(productPagePriceForJacket, cartPagePriceForJacket, productJacket);
		AssertionUtil.equals(productPagePriceForOnesie, cartPagePriceForOnesie, productOnesie);

		manager.getCartPage().clickRemoveBtnOnCartPage(productOnesie);
		manager.getCartPage().getProductQuantity(productJacket);
		String cartQuantityAfter = manager.getProductsPage().getCartQuantity();
		AssertionUtil.notEquals(cartQuantityBefore, cartQuantityAfter, "Cart quantity after product removal");

		manager.getCartPage().clickCheckoutBtn()
				.sendFirstName(RandomUtils.getFirstName())
				.sendLastName(RandomUtils.getLastName())
				.sendPostalCode(RandomUtils.getZipCode())
				.clickContinueBtn();
		String itemTotal = manager.getCheckoutPage().getItemTotalOnCheckout();
		AssertionUtil.equals(itemTotal, cartPagePriceForJacket, "Item total");

		manager.getCheckoutPage().clickFinishBtn().isOrderCompletedMessageDisplayed();
		manager.getCheckoutPage().getThankYouText();

	}

	@TestAnnotation(module = CHECKOUT, user = JONDOE)
	@Test(groups = { REGRESSSION }, description = "Error user - TC04")
	public void addProductToCartAndCheckout() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		String productName = "Sauce Labs Bike Light";
		boolean isplacedOrderMessageDisplayed = manager.getPlaceOrderHelper()
				.placeOrder(PropUtil.getConfig().errorusername(),PropUtil.getConfig().userpassword(), productName);
		AssertionUtil.isTrue(isplacedOrderMessageDisplayed, "Place order message");
	}

}
