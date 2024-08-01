package com.wtw.helper;

import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import com.wtw.extentreport.ExtentLogger;
import com.wtw.utils.DriverUtilites;

public class FooterHelper {

	private WebDriver driver;

	public FooterHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void handleChildWindows(String parentWindowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String childWindow : windowHandles) {
			if (!childWindow.equals(parentWindowHandle)) {
				try {
					driver.switchTo().window(childWindow);
					String currentURL = driver.getCurrentUrl();
					if (currentURL.contains("facebook")) {
						logAndCloseTab("Facebook", currentURL);
					} else if (currentURL.contains("twitter") || currentURL.contains("x.com")) {
						logAndCloseTab("X", currentURL);
					} else if (currentURL.contains("linkedin")) {
						ExtentLogger.info("LinkedIn URL: " + currentURL, true);
					}
				} catch (NoSuchWindowException e) {
					ExtentLogger.fail("Window is already closed: " + childWindow, true);
				}
			}
		}
	}

	public void handleLinkedInWindow(String parentWindowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String childWindow : windowHandles) {
			if (!childWindow.equals(parentWindowHandle)) {
				try {
					DriverUtilites.switchToWindow(childWindow);
					String currentURL = driver.getCurrentUrl();
					if (currentURL.contains("linkedin")) {
						logAndCloseTab("Linkdein", currentURL);
						DriverUtilites.switchToWindow(parentWindowHandle);
					}
				} catch (NoSuchWindowException e) {
					ExtentLogger.fail("LinkedIn window is already closed: " + childWindow, true);
				}
			}
		}
	}

	public void logAndCloseTab(String tabName, String url) {
		ExtentLogger.pass("Closing " + tabName + " window: " + url, true);
		DriverUtilites.closeCurrentWindow();
	}

}