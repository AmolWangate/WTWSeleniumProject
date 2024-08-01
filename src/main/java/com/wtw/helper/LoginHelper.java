package com.wtw.helper;

import org.openqa.selenium.WebDriver;

import com.wtw.pompages.LoginPage;
import com.wtw.pompages.ProductsPage;

public class LoginHelper {

	private WebDriver driver;

	public LoginHelper(WebDriver driver) {
		this.driver = driver;
    }

    public ProductsPage login(String username, String password) {
    	LoginPage loginPage = new LoginPage(driver);
    	return loginPage.sendUserName(username)
                 .sendUserPWD(password)
                 .clickLoginBtn();
    }
}
