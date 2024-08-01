package com.wtw.driverfactory;

import org.openqa.selenium.WebDriver;

/**
 * @author Amol Wangate
 * @summary This class provides thread local driver implementation for parallel
 *          execution. The unload method is for clearing WebDriver instances
 *          stored in a ThreadLocal variable after tests are completed to ensure
 *          that each thread has a clean state.
 */

public final class DriverManager {

	private DriverManager() {

	}

	static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	static synchronized void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	static synchronized void unload() {
		tlDriver.remove();
	}
}
