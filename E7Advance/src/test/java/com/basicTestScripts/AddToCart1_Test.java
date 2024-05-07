package com.basicTestScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.elementRepo.CellPhonesPage;
import com.elementRepo.ElectronicsPage;
import com.genericClasses.BaseClass;

public class AddToCart1_Test extends BaseClass{
	@Test
	public void addingSmartPhoneToCart() {
		ExtentTest test=extent.createTest("Adding to Cart");
		basepage.getElectronics().click();
		test.pass("Electronics link clicked");
		ElectronicsPage elepage=new ElectronicsPage(driver);
		elepage.getCellphoneLink().click();
		test.pass("Cell phone link clicked");
		CellPhonesPage cellpage=new CellPhonesPage(driver);
		cellpage.getSmartPhone().click();
		test.pass("Clicked on SmartPhone");
		cellpage.getAddToCartButton().click();
		test.pass("Added to the cart");
	}
}
