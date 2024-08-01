package com.wtw.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wtw.constants.FrameworkConstants;
import com.wtw.customexception.InvalidWaitTypeException;
import com.wtw.driverfactory.DriverManager;
import com.wtw.enums.WaitType;

/**
 * @author Amol Wangate
 * @summary This utility class is for performing explicit waits on web elements.
 *          The `WaitUtility` class provides a static method to handle various
 *          types of explicit waits. It supports different wait strategies, such
 *          as waiting for elements to be clickable or visible.
 */
public final class WaitUtility {

	private WaitUtility() {

	}

	public static WebElement performExplicitWait(WebElement element, WaitType waitStrategy) {
		WebElement webElement = null;
		switch (waitStrategy) {
		case CLICKABLE:
			webElement = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case VISIBLE:
			webElement = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOf(element));
			break;
		case NONE:
			webElement = element;
			break;
		default:
			throw new InvalidWaitTypeException("Invalid wait type: " + waitStrategy.name());
		}
		return webElement;
	}

}
