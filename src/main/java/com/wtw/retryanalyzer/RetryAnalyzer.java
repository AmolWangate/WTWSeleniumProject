package com.wtw.retryanalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.wtw.ownerfactory.PropUtil;

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
	
