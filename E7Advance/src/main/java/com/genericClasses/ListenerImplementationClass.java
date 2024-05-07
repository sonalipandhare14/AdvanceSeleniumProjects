package com.genericClasses;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementationClass extends BaseClass implements ITestListener{
	LocalDateTime ldt=LocalDateTime.now();
	String date=ldt.toString().replace(":", "-");
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("[ TestCase ***"+result.getName()+"*** Started ]",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[ TestCase ***"+result.getName()+"*** Success ]",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("[ TestCase ***"+result.getName()+"*** failure ]",true);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(SCREENSHOT_PATH+result.getName()+date+"errorshot.png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("[ TestCase ***"+result.getName()+"*** skipped ]",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("[ <test> ***"+context.getName()+"*** Started ]",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("[ <test> ***"+context.getName()+"*** Finish ]",true);
	}
	
	
	
	
	
}
