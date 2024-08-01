package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.objectmanager.ObjectManager;
import com.wtw.pompages.ProductsPage;

/**
 * @author Amol Wangate
 * @summary This class provides a method to perform the login action. It uses
 *          the provided username and password to log in and then returns the
 *          ProductsPage instance upon login.
 */
public class LoginHelper {

	private WebDriver driver;

	public LoginHelper(WebDriver driver) {
		this.driver = driver;
	}

	public ProductsPage login(String username, String password) {
		ObjectManager manager = new ObjectManager(driver);
		return manager.getLoginPage()
				.sendUserName(username)
				.sendUserPWD(password)
				.clickLoginBtn();
	}
}
