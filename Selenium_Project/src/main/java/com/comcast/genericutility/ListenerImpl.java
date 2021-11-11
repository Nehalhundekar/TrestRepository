package com.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImpl implements ITestListener {

	public void onFinish(ITestContext context) {
		
		
	}

	public void onStart(ITestContext context) {
		
	}

	

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		String methodName = result.getMethod().getMethodName();
		Object Obj = result.getInstance();
		 try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(Obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+methodName+".PNG");
				try {
					Files.copy(src, dst);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
	}

	
}
