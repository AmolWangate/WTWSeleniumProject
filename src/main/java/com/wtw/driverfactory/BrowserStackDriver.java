package com.wtw.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wtw.customexception.DriverInitalizationException;
import com.wtw.enums.BrowserType;
import com.wtw.ownerfactory.PropUtil;

public class BrowserStackDriver implements IDriver {

	@Override
	public WebDriver getDriverInstance(BrowserType browserType) {
		WebDriver driver = null;
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<>();
		capabilities.setCapability("browserName", PropUtil.getConfig().browserName());
		bstackOptions.put("os", PropUtil.getConfig().os());
		bstackOptions.put("userName", PropUtil.getConfig().userName());
		bstackOptions.put("accessKey", PropUtil.getConfig().accessKey());
		bstackOptions.put("osVersion", PropUtil.getConfig().osVersion());
		bstackOptions.put("browserVersion", PropUtil.getConfig().browserVersion());
		bstackOptions.put("consoleLogs", PropUtil.getConfig().consoleLogs());
		bstackOptions.put("seleniumVersion", PropUtil.getConfig().seleniumVersion());
		capabilities.setCapability("bstack:options", bstackOptions);
		try {
			driver = new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub/"), capabilities);
		} catch (MalformedURLException e) {
			throw new DriverInitalizationException("Driver could not be launched: " + e.getMessage(), e.getCause());
		}
		return driver;
	}

}
