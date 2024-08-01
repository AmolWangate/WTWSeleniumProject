package com.wtw.pompages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.helper.PriceValidation;
import com.wtw.utils.DriverUtilites;
import com.wtw.utils.DynamicXpathUtil;

public class ProductsPage {

	@FindBy(id = "react-burger-menu-btn")
	private WebElement hamburgerMenu;

	@FindBy(className = "shopping_cart_link")
	private WebElement iconCart;

	@FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
	private WebElement textCartQuantity;

	@FindBy(xpath = "//*[@class='product_sort_container']")
	private WebElement ddSort;

	@FindBy(xpath = "//div[@data-test='inventory-item-price']")
	private List<WebElement> textPricesList;

	String btnAddToCart = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item_description']//button[contains(.,'Add')]";
	String btnRemove = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item_description']//button[contains(.,'Remove')]";
	String textProductPrice = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item_description']//div[@data-test='inventory-item-price']";

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HamburgerMenuPage clickHamburgerMenu() {
		DriverUtilites.click(hamburgerMenu, WaitType.CLICKABLE, "Hamburger Menu");
		return new HamburgerMenuPage(driver);
	}

	public ProductsPage clickOnAddToCartBtn(String productName) {
		WebElement addToCartElement = DynamicXpathUtil.getDynamicXpath(btnAddToCart, productName);
		DriverUtilites.scrollToElement(addToCartElement);
		DriverUtilites.click(addToCartElement, WaitType.CLICKABLE, "Add to cart button for " + productName);
		return this;
	}

	public boolean isAddToCartButtonDisplayed(String productName) {		
		WebElement addToCartElement = DynamicXpathUtil.getDynamicXpath(btnAddToCart, productName);
		DriverUtilites.scrollToElement(addToCartElement);
		return DriverUtilites.isDisplayed(addToCartElement, WaitType.VISIBLE, "Add to cart button for " + productName);
	}

	public CartPage clickCartIcon() {
		DriverUtilites.click(iconCart, WaitType.CLICKABLE, "Cart icon");
		return new CartPage(driver);
	}

	public ProductsPage clickRemoveBtn(String productName) {
		WebElement removeButtonElement = DynamicXpathUtil.getDynamicXpath(btnRemove, productName);
		DriverUtilites.scrollToElement(removeButtonElement);
		DriverUtilites.click(removeButtonElement, WaitType.CLICKABLE, "Remove button for product " + productName);
		return this;
	}

	public boolean isRemoveButtonDisplayed(String productName) {
		WebElement removeButtonElement = DynamicXpathUtil.getDynamicXpath(btnRemove, productName);
		DriverUtilites.scrollToElement(removeButtonElement);
		return DriverUtilites.isDisplayed(removeButtonElement, WaitType.VISIBLE, "Remove button for " + productName);
	}

	public boolean isQuantityTextOnCartIconDisplayed() {
		DriverUtilites.scrollToElement(textCartQuantity);
		return DriverUtilites.isDisplayed(textCartQuantity, WaitType.VISIBLE, "cart quantity");
	}

	public String getCartQuantity() {
		DriverUtilites.scrollToElement(textCartQuantity);
		return DriverUtilites.getText(textCartQuantity, WaitType.VISIBLE, "cart quantity");
	}

	public ProductsPage selectFilter(String filterName) {
		DriverUtilites.selectDDByText(ddSort, WaitType.VISIBLE, filterName, "Sort filter dropdown");
		return this;
	}

	public String getSortFilterSlectedOption() {
		return DriverUtilites.getSelectedOption(ddSort, WaitType.VISIBLE, "Sort filter dropdown");

	}

	public boolean arePricesInAsceandingOrder() {
		return PriceValidation.verifyPricesAreInAscendingOrder(textPricesList);
	}

	public String getProductPrice(String productName) {
		WebElement priceElement = DynamicXpathUtil.getDynamicXpath(textProductPrice, productName);
		DriverUtilites.scrollToElement(priceElement);
		return DriverUtilites.getText(priceElement, WaitType.CLICKABLE,
				"Product price on products page for " + productName);
	}

}
