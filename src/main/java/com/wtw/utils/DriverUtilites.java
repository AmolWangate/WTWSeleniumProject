package com.wtw.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.wtw.driverfactory.DriverManager;
import com.wtw.enums.WaitType;
import com.wtw.extentreport.ExtentLogger;

/**
 * @author Amol Wangate
 * @summary This utility class is for providing common actions and interactions
 *          for WebDriver operations.
 */
public final class DriverUtilites {

	private DriverUtilites() {

	}

	public static void click(WebElement element, WaitType waitType, String elementName) {
		WaitUtility.performExplicitWait(element, waitType).click();
		ExtentLogger.info(elementName + " is clicked", true);
	}

	public static void sendKeys(WebElement element, WaitType waitType, String textToBeEntered, String elementName) {
		WebElement element2 = WaitUtility.performExplicitWait(element, waitType);
		element2.clear();
		element2.sendKeys(textToBeEntered);
		ExtentLogger.info("Entered " + textToBeEntered + " in " + elementName, true);
	}

	public static String getText(WebElement element, WaitType waitType, String elementName) {
		String text = WaitUtility.performExplicitWait(element, waitType).getText();
		ExtentLogger.info("Text value for " + elementName + " is " + text, true);
		return text;
	}

	public static boolean isDisplayed(WebElement element, WaitType waitType, String elementName) {
		boolean isDisplayed;
		if (element == null) {
			ExtentLogger.info(elementName + " is not displayed", true);
			return false;
		}
		try {
			isDisplayed = WaitUtility.performExplicitWait(element, waitType).isDisplayed();
			ExtentLogger.info(elementName + " is displayed", true);
		} catch (NoSuchElementException | TimeoutException e) {
			isDisplayed = false;
		}
		ExtentLogger.info("is " + elementName + " displayed : " + isDisplayed, true);
		return isDisplayed;
	}

	public static void scrollToElement(WebElement element) {
		if (element == null) {
			return;
		}
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (NoSuchElementException | TimeoutException e) {
			ExtentLogger.info("could not scroll to the element");
		}
	}

	public static void jsClick(WebElement element, WaitType waitType, String elementName) {
		WebElement clickElement = WaitUtility.performExplicitWait(element, waitType);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", clickElement);
		ExtentLogger.info(elementName + " is clicked", true);
	}

	public static void refreshPage() {
		DriverManager.getDriver().navigate().refresh();
	}

	public static String getParentWindowHandle() {
		return DriverManager.getDriver().getWindowHandle();
	}

	public static void switchToWindow(String windowHandle) {
		DriverManager.getDriver().switchTo().window(windowHandle);
	}

	public static void closeCurrentWindow() {
		DriverManager.getDriver().close();
	}

	public static void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void selectDDByText(WebElement element, WaitType waitType, String ddText, String elementName) {
		WebElement selectElement = WaitUtility.performExplicitWait(element, waitType);
		Select select = new Select(selectElement);
		select.selectByVisibleText(ddText);
		ExtentLogger.info(ddText + " is selected from dropdown " + elementName, true);
	}

	public static String getSelectedOption(WebElement element, WaitType waitType, String elementName) {
		WebElement selectElement = WaitUtility.performExplicitWait(element, waitType);
		Select select = new Select(selectElement);
		String selectedOption = select.getFirstSelectedOption().getText();
		ExtentLogger.info(selectedOption + " is selected in dropdown " + elementName, true);
		return selectedOption;
	}
}
