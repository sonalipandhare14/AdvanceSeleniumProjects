package com.genericClasses;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

public class UtilityMethods extends BaseClass{
	
	public void switchToASpecificTitledWindow(WebDriver driver, String title) {
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}
	
	public void switchToASpecificWindow(WebDriver driver, WebElement element) {
		String parent = driver.getWindowHandle();
		Set<String> allWid = driver.getWindowHandles();
		allWid.remove(parent);
		for (String sessionID : allWid) {
			driver.switchTo().window(sessionID);
			if (element.isDisplayed()) {
				break;
			}
		}
	}
	
	public void captureScreen(WebDriver driver, ITestResult result) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File tempFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SCREENSHOT_PATH+ result.getName() + date + ".png");
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToFrameUsingNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameUsingElement(WebDriver driver, WebElement targetElement) {
		driver.switchTo().frame(targetElement);
	}

}
