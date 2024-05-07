package com.genericClasses;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.elementRepo.BasePage;
import com.elementRepo.LoginPage;

public class BaseClass implements FrameWorkConstants{
	public static WebDriver driver;
	public static ReadingData prop;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static LocalDateTime ldt=LocalDateTime.now();
	public static String date=ldt.toString().replace(":", "-");
	public static BasePage basepage;
	public static LoginPage loginpage;
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Before suite",true);
		Reporter.log("configuring reports");
		spark = new ExtentSparkReporter(EXTENT_REPORT_PATH+"extentreport"+date+".html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("After Suite",true);
		Reporter.log("flush the report");
		extent.flush();
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After Test",true);
	}
	
	@Parameters("bname")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		Reporter.log("Before Class",true);
		Reporter.log("Launch browser, maximize and load Url");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		prop=new ReadingData();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
		driver.get(prop.fetchProperty("url"));
		basepage = new BasePage(driver);
		
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After Class",true);
		Reporter.log("Close the browser and end the session");
		driver.close();
		driver.quit();
	}
	
	@BeforeMethod
	public void beforemethod() {
		Reporter.log("Before method",true);
		Reporter.log("Login");
		basepage.getLoginLink().click();
		loginpage=new LoginPage(driver);
		
		loginpage.getEmailTextBox().sendKeys(prop.fetchProperty("email"));
		loginpage.getPasswordTextBox().sendKeys(prop.fetchProperty("password"));
		loginpage.getLoginButton().click();
	}
	
	@AfterMethod
	public void aftermethod() {
		Reporter.log("After method",true);
		Reporter.log("logout");
		basepage.getLogoutLink().click();
	}
}
