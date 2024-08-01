package com.wtw.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wtw.enums.WaitType;
import com.wtw.utils.DriverUtilites;

public class LoginPage {

	@FindBy(id = "user-name")
	private WebElement inputUserName;

	@FindBy(id = "password")
	private WebElement inputUserPwd;

	@FindBy(id = "login-button")
	private WebElement btnLogin;

	@FindBy(className = "login_logo")
	private WebElement logoLogin;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMessage;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage sendUserName(String userName) {
		DriverUtilites.sendKeys(inputUserName, WaitType.VISIBLE, userName, "user name");
		return this;
	}

	public LoginPage sendUserPWD(String userPWD) {
		DriverUtilites.sendKeys(inputUserPwd, WaitType.VISIBLE, userPWD, "user password");
		return this;
	}

	public ProductsPage clickLoginBtn() {
		DriverUtilites.click(btnLogin, WaitType.CLICKABLE, "login button");
		return new ProductsPage(driver);
	}

	public boolean isLoginLogoDisplayed() {
		return DriverUtilites.isDisplayed(logoLogin, WaitType.VISIBLE, "Login logo");
	}

	public boolean isLoginErrorMessageDisplayed() {
		return DriverUtilites.isDisplayed(errorMessage, WaitType.VISIBLE, "Error message on login page");
	}

	public String getLockedErrorMessage() {
		return DriverUtilites.getText(errorMessage, WaitType.VISIBLE, "Error message on login page");
	}

}
