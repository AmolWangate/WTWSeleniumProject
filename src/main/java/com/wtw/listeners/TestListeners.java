package com.wtw.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.wtw.customannotation.TestAnnotation;
import com.wtw.extentreport.ExtentInitializer;
import com.wtw.extentreport.ExtentLogger;

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
