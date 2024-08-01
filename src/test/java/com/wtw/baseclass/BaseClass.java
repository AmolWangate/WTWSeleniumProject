package com.wtw.baseclass;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.wtw.driverfactory.DriverFactory;
import com.wtw.enums.BrowserType;
import com.wtw.enums.RunMode;
import com.wtw.ownerfactory.IPropReader;

public class BaseClass {

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		IPropReader configInterface = ConfigFactory.create(IPropReader.class);
		String browser = System.getProperty("browser", configInterface.browser());
		String mode = System.getProperty("mode", configInterface.mode());
		DriverFactory.initDriver(BrowserType.valueOf(browser.toUpperCase()), RunMode.valueOf(mode.toUpperCase()));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quit();
	}
}
