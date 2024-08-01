package com.wtw.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wtw.baseclass.BaseClass;
import com.wtw.customannotation.TestAnnotation;
import com.wtw.driverfactory.DriverManager;
import com.wtw.helper.AssertionUtil;
import com.wtw.listeners.TestListeners;
import com.wtw.objectmanager.ObjectManager;
import com.wtw.ownerfactory.PropUtil;
import com.wtw.pompages.LoginPage;
import static com.wtw.constants.TestConstants.*;

@Listeners(TestListeners.class)
public class LoginTests extends BaseClass {

	@TestAnnotation(module = LOGIN, user = AMOL)
	@Test(groups = SMOKE, description = "Successful login and logout - TC01")
	public void loginLogoutValidationWithValidCred() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		boolean isLoginLogoDisplayed = manager.getLoginHelper()
				.login(PropUtil.getConfig().validusername(), PropUtil.getConfig().userpassword())
				.clickHamburgerMenu()
				.clickLogoutLink()
				.isLoginLogoDisplayed();
		AssertionUtil.isTrue(isLoginLogoDisplayed, "Login logo");
	}

	@TestAnnotation(module = LOGIN, user = JONDOE)
	@Test(groups = SMOKE, description = "Failed login - TC02")
	public void loginValidationWithInvalidCred() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		manager.getLoginHelper().login(PropUtil.getConfig().lockedusername(), PropUtil.getConfig().userpassword());
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
		AssertionUtil.isTrue(loginPage.isLoginErrorMessageDisplayed(), "Login error message");
	}
}
