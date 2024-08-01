package com.wtw.driverfactory;

import org.openqa.selenium.WebDriver;

import com.wtw.enums.BrowserType;

/**
 * @Author Amol Wangate
 * @summary This interface provides a contract for obtaining WebDriver instances
 *          based on the specified browser type. The IDriver interface defines
 *          a single method, getDriverInstance, which must be implemented by
 *          any class that provides WebDriver instances. The method takes a
 *          BrowserType parameter, which indicates the type of browser for
 *          which the WebDriver instance is required, and returns an initialized
 *          WebDriver instance.
 */
public interface IDriver {

	public WebDriver getDriverInstance(BrowserType browserType);
}
