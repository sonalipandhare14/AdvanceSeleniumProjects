package com.genericClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {
	JavascriptExecutor js;
	
	public JavaScriptUtilities(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
	
	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void jsSendkeys(String data,WebElement element) {
		js.executeScript("arguments[0].value='"+data+"';", element);
	}
	
	public void jsScrollBy(int X,int Y) {
		js.executeScript("window.scrollBy("+X+","+Y+")");
	}

	public void jsScrollTo(int X,int Y) {
		js.executeScript("window.scrollTo("+X+","+Y+")");
	}

	public void jsScrollIntoView(boolean bool,WebElement element) {
		js.executeScript("arguments[0].scrollIntoView("+bool+")",element);
	}

	public void jsScrollToBottomOfThePage() {
		js.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
	}
}
