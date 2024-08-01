package com.wtw.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.wtw.driverfactory.DriverManager;

public final class DynamicXpathUtil {

	private DynamicXpathUtil() {

	}

	public static WebElement getDynamicXpath(String locator, String productName) {
	    String newLocator = String.format(locator, productName);
	    try {
	        return DriverManager.getDriver().findElement(By.xpath(newLocator));
	    } catch (NoSuchElementException e) {
	        return null;
	    }
	}
}
