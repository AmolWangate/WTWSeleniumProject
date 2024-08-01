package com.wtw.extentreport;

import com.wtw.ownerfactory.PropUtil;

/**
 * @author Amol Wangate
 * @summary This class provides methods for logging different types of messages
 *          (pass, fail, skip, info) to ExtentReports. It also supports
 *          conditional screenshot capturing based on the logging level and
 *          configuration settings. Condition screenshots are driven from
 *          envconfig.properties file by changing the value of passscreenshot,
 *          failscreenshot, skipscreenshot, infoscreenshot to true to false as
 *          required.
 */

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message, boolean isTrue) {
		if (isTrue && PropUtil.getConfig().infoscreenshot()) {
			ExtentManager.getExtentTest().info(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			info(message);
		}
	}

	public static void pass(String message, boolean isTrue) {
		if (isTrue && PropUtil.getConfig().passscreenshot()) {
			ExtentManager.getExtentTest().pass(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isTrue) {
		if (isTrue && PropUtil.getConfig().failscreenshot()) {
			ExtentManager.getExtentTest().fail(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isTrue) {
		if (isTrue && PropUtil.getConfig().skipscreenshot()) {
			ExtentManager.getExtentTest().skip(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			skip(message);
		}
	}

	public static void setOwner(String authorName) {
		ExtentManager.getExtentTest().assignAuthor(authorName);
	}

	public static void setCategory(String module) {
		ExtentManager.getExtentTest().assignCategory(module);
	}

	public static void setDevice(String deviceName) {
		ExtentManager.getExtentTest().assignDevice(deviceName);
	}
}
