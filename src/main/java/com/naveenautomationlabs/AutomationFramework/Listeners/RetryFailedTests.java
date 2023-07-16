package com.naveenautomationlabs.AutomationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {

	int count =1;
	int maxCount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying Failed test!!!"+result.getMethod().getMethodName() + " for " + count + "times");
		if(count<maxCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
