package com.wtw.retryanalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.wtw.ownerfactory.PropUtil;

/**
 * @author Amol Wangate
 * @summary The RetryAnalyzer class implements IRetryAnalyzer to provide custom
 *          retry logic for failed test methods. It allows a test method to be
 *          retried a specified number of times before it is marked as failed.
 *          The retry count value is driven from envconfig.properties
 */
public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (count < PropUtil.getConfig().retrycount()) {
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}

		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
