package com.wtw.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.utils.DriverUtilites;

/**
 * @author Amol Wangate
 * @summary POM class for storing all locators from hamburger menu page. It
 *          provides methods to interact with elements on the hamburger menu
 *          page
 */
public class HamburgerMenuPage {

	@FindBy(id = "logout_sidebar_link")
	private WebElement linkLogout;

	@FindBy(id = "reset_sidebar_link")
	private WebElement linkResetAppState;

	@FindBy(id = "inventory_sidebar_link")
	private WebElement linkAllItems;

	private WebDriver driver;

	public HamburgerMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogoutLink() {
		DriverUtilites.click(linkLogout, WaitType.CLICKABLE, "Logout button");
		return new LoginPage(driver);
	}

	public ProductsPage clickResetAppStateLink() {
		DriverUtilites.click(linkResetAppState, WaitType.CLICKABLE, "Reset app state link");
		return new ProductsPage(driver);
	}

	public ProductsPage clickAllItemsLink() {
		DriverUtilites.click(linkAllItems, WaitType.CLICKABLE, "All items link");
		return new ProductsPage(driver);
	}

	public void refreshPage() {
		DriverUtilites.refreshPage();
	}
}
