package com.wtw.baseclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.wtw.driverfactory.DriverFactory;
import com.wtw.enums.BrowserType;
import com.wtw.enums.RunMode;
import com.wtw.ownerfactory.PropUtil;

/**
 * @author Amol Wangate
 * @summary This class provides common setup and teardown methods that are
 *          executed before and after each test method. It initializes the
 *          WebDriver based on configuration settings provided during
 *          local/remote or command line execution
 */
public class BaseClass {

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		String browser = System.getProperty("browser", PropUtil.getConfig().browser());
		String mode = System.getProperty("mode", PropUtil.getConfig().mode());
		DriverFactory.initDriver(BrowserType.valueOf(browser.toUpperCase()), RunMode.valueOf(mode.toUpperCase()));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quit();
	}
}
