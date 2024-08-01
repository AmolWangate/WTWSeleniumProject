package com.wtw.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.wtw.driverfactory.DriverManager;

/**
 * @author Amol Wangate
 * @summary This utility class is for handling dynamic XPath locators. The
 *          DynamicXpathUtil class provides a static method for locating web
 *          elements using dynamic XPath expressions. It allows you to construct
 *          XPath locators by inserting variable values (e.g., product names)
 *          into predefined XPath templates.
 */
public final class DynamicXpathUtil {

	private DynamicXpathUtil() {

	}

	public static WebElement getDynamicXpath(String locator, String value) {
		String newLocator = String.format(locator, value);
		try {
			return DriverManager.getDriver().findElement(By.xpath(newLocator));
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}
