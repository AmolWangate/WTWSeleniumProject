package com.wtw.driverfactory;

import org.openqa.selenium.WebDriver;

import com.wtw.enums.BrowserType;

public interface IDriver {
	
	public WebDriver getDriverInstance(BrowserType browserType);
}
