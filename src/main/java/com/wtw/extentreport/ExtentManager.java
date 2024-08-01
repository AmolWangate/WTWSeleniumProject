package com.wtw.extentreport;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Amol Wangate
 * @summary This class is for managing ExtentTest instances in a thread-safe
 *          manner during parallel execution
 */
public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlExtent = new ThreadLocal<>();

	static synchronized void setExtentTest(ExtentTest extentTest) {
		tlExtent.set(extentTest);
	}

	static synchronized ExtentTest getExtentTest() {
		return tlExtent.get();
	}

	static void unload() {
		tlExtent.remove();
	}
}
