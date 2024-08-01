package com.wtw.objectmanager;

import org.openqa.selenium.WebDriver;

import com.wtw.helper.FooterHelper;
import com.wtw.helper.LoginHelper;
import com.wtw.helper.PlaceOrderHelper;
import com.wtw.helper.ProductsPageHelper;
import com.wtw.pompages.CartPage;
import com.wtw.pompages.CheckoutPage;
import com.wtw.pompages.FooterPage;
import com.wtw.pompages.HamburgerMenuPage;
import com.wtw.pompages.LoginPage;
import com.wtw.pompages.ProductsPage;

public class ObjectManager {

	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private FooterPage footerPage;
	private FooterHelper footerHelper;
	private HamburgerMenuPage menuPage;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private LoginHelper loginHelper;
	private PlaceOrderHelper orderHelper;
	private ProductsPageHelper productsPageHelper;
	private WebDriver driver;

	public ObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public CartPage getCartPage() {
		if (cartPage == null) {
			cartPage = new CartPage(driver);
		}
		return cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		if (checkoutPage == null) {
			checkoutPage = new CheckoutPage(driver);
		}
		return checkoutPage;
	}

	public FooterPage getFooterPage() {
		if (footerPage == null) {
			footerPage = new FooterPage(driver);
		}
		return footerPage;
	}

	public HamburgerMenuPage getMenuPage() {
		if (menuPage == null) {
			menuPage = new HamburgerMenuPage(driver);
		}
		return menuPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public ProductsPage getProductsPage() {
		if (productsPage == null) {
			productsPage = new ProductsPage(driver);
		}
		return productsPage;
	}

	public FooterHelper getFooterHelper() {
		if (footerHelper == null) {
			footerHelper = new FooterHelper(driver);
		}
		return footerHelper;
	}

	public LoginHelper getLoginHelper() {
		if (loginHelper == null) {
			loginHelper = new LoginHelper(driver);
		}
		return loginHelper;
	}

	public PlaceOrderHelper getPlaceOrderHelper() {
		if (orderHelper == null) {
			orderHelper = new PlaceOrderHelper(driver);
		}
		return orderHelper;
	}

	public ProductsPageHelper getProductsPageHelper() {
		if (productsPageHelper == null) {
			productsPageHelper = new ProductsPageHelper(driver);
		}
		return productsPageHelper;
	}
}