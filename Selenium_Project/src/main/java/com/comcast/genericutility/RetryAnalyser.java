package com.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	int count=0;
	int retryCount=4;
	public boolean retry(ITestResult arg0) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
