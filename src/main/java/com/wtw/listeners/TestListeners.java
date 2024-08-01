package com.wtw.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.wtw.customannotation.TestAnnotation;
import com.wtw.extentreport.ExtentInitializer;
import com.wtw.extentreport.ExtentLogger;

/**
 * @author Amol Wangate
 * @summary TestNG listener class for managing ExtentReports during test
 *          execution. This class implements the ISuiteListene and ITestListener
 *          interfaces to hook into TestNG's test lifecycle events. It uses
 *          ExtentReports to generate and manage test reports, including
 *          capturing test results and metadata such as authors and categories
 *          from TestAnnontation provided on @Test level
 */

public class TestListeners implements ISuiteListener, ITestListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentInitializer.createReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentInitializer.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentInitializer.createTest(result.getMethod().getDescription());
		ExtentLogger.setOwner(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).user());
		ExtentLogger.setCategory(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).module());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getThrowable().toString() + " is failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getThrowable().toString() + " is skipped", true);
	}
}
