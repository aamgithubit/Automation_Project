package com.testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itestlisteners extends BaseClass1 implements ITestListener  {
	
	public void OnStart(ITestResult result) {
		System.out.println("start running");
	}
	public void onTestStart(ITestResult result) {
		System.out.println("actual test start running");
		}
	public void onTestSuccess(ITestResult result) {
		System.out.println("passed test");
	}
	public void onTestFailure(ITestResult result) {
		try {
			System.out.println(result.getMethod().getMethodName());
			captureScreenshot();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		System.out.println("done done");
	}

}
