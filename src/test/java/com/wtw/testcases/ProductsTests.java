
package com.wtw.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wtw.baseclass.BaseClass;
import com.wtw.customannotation.TestAnnotation;
import com.wtw.driverfactory.DriverManager;
import com.wtw.helper.AssertionUtil;
import com.wtw.helper.ProductsPageHelper;
import com.wtw.listeners.TestListeners;
import com.wtw.objectmanager.ObjectManager;
import com.wtw.ownerfactory.PropUtil;
import com.wtw.pompages.HamburgerMenuPage;
import com.wtw.pompages.ProductsPage;
import com.wtw.utils.DriverUtilites;
import static com.wtw.constants.TestConstants.*;

@Listeners(TestListeners.class)
public class ProductsTests extends BaseClass {

	@TestAnnotation(module = PRODUCTS, user = AMOL)
	@Test(groups = { REGRESSSION}, description = "Browser refresh - TC05")
	public void validateResetAppSateWithBrowserRefresh() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		String productName = "Sauce Labs Bolt T-Shirt";
		ProductsPage productsPage = manager.getProductsPageHelper()
				.addAProductToCart(PropUtil.getConfig().validusername(),PropUtil.getConfig().userpassword(), productName)
				.clickHamburgerMenu()
				.clickResetAppStateLink();
		DriverUtilites.refreshPage();

		AssertionUtil.isFalse(productsPage.isRemoveButtonDisplayed(productName), "Remove button");
		AssertionUtil.isTrue(productsPage.isAddToCartButtonDisplayed(productName), "Add to cart button");
		AssertionUtil.isFalse(productsPage.isQuantityTextOnCartIconDisplayed(), "Quantity icon");
	}

	@TestAnnotation(module = PRODUCTS, user = AMOL)
	@Test(groups = { REGRESSSION, SMOKE }, description = "Performance user - TC06")
	public void validateRemoveFunctionalityWithPerUser() {
		ObjectManager manager=new ObjectManager(DriverManager.getDriver());
		String productName = "Sauce Labs Bolt T-Shirt";
		manager.getProductsPageHelper().addAProductToCart(PropUtil.getConfig().performanceglitchuser(),PropUtil.getConfig().userpassword(), productName)
						.clickHamburgerMenu()
						.clickAllItemsLink()
						.clickRemoveBtn(productName);
		AssertionUtil.isTrue(manager.getMenuPage().clickLogoutLink().isLoginLogoDisplayed(),"login logo post logout");
	}
}
