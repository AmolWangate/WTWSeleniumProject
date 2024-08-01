package com.wtw.helper;

import com.wtw.extentreport.ExtentLogger;

/**
 * @author Amol Wangate
 * @summary This utility class is for performing assertions in test cases. This
 *          class provides static methods to perform common assertion operations
 *          and log the results using ExtentLogger.
 */
public final class AssertionUtil {

	private AssertionUtil() {

	}

	public static void isTrue(boolean booleanValue, String elementName) {
		if (booleanValue) {
			ExtentLogger.pass(elementName + " is displayed as expected", true);
		} else {
			ExtentLogger.fail(elementName + " is not displayed", true);
		}
	}

	public static void isFalse(boolean booleanValue, String elementName) {
		if (!booleanValue) {
			ExtentLogger.pass(elementName + " is not displayed as expected", true);
		} else {
			ExtentLogger.fail(elementName + " is displayed", true);
		}
	}

	public static void equals(String actual, String expected, String elementName) {
		if (actual.equals(expected)) {
			ExtentLogger.pass("Actual value " + actual + " is equals to " + expected + " for " + elementName, true);
		} else {
			ExtentLogger.fail("Actual value " + actual + " is not equals to " + expected + " for " + elementName, true);
		}
	}

	public static void equals(int actual, int expected, String elementName) {
		if (actual == expected) {
			ExtentLogger.pass("Actual value " + actual + " is equals to " + expected + " for " + elementName, true);
		} else {
			ExtentLogger.fail("Actual value " + actual + " is not equals to " + expected + " for " + elementName, true);
		}
	}

	public static void notEquals(String actual, String expected, String elementName) {
		if (!actual.equals(expected)) {
			ExtentLogger.pass("Actual value " + actual + " is not equals to " + expected + " for " + elementName, true);
		} else {
			ExtentLogger.fail("Actual value " + actual + " is equals to " + expected + " for " + elementName, true);
		}
	}
}
