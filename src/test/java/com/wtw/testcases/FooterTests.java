package com.wtw.testcases;

import static com.wtw.constants.TestConstants.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wtw.baseclass.BaseClass;
import com.wtw.customannotation.TestAnnotation;
import com.wtw.driverfactory.DriverManager;
import com.wtw.listeners.TestListeners;
import com.wtw.objectmanager.ObjectManager;
import com.wtw.ownerfactory.PropUtil;
import com.wtw.pompages.ProductsPage;
import com.wtw.utils.DriverUtilites;

/**
 * @author Amol Wangate
 * @summary This class has all related tests for footer scenarios 
 */
@Listeners(TestListeners.class)
public class FooterTests extends BaseClass {

	@TestAnnotation(module = HEADER, user = AMOL)
	@Test(groups = SIT, description = "Bonus Test case - TC07")
	public void validateFooterSocialMediaLinksInFooter() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		
		ProductsPage productsPage = manager.getLoginHelper().login(PropUtil.getConfig().validusername(),
				PropUtil.getConfig().userpassword());
		String parentWindowHandle = DriverUtilites.getParentWindowHandle();
		manager.getFooterPage().clickTwitterIcon()
				  .clickFacebookIcon()
				  .clickLinkedinIcon();
		manager.getFooterHelper().handleChildWindows(parentWindowHandle);
		DriverUtilites.switchToWindow(parentWindowHandle);
		productsPage.clickHamburgerMenu().clickLogoutLink();
		manager.getFooterHelper().handleLinkedInWindow(parentWindowHandle);
	}

}
