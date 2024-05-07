package com.basicTestScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.elementRepo.CellPhonesPage;
import com.elementRepo.ElectronicsPage;
import com.genericClasses.BaseClass;

public class AddToCart2_Test extends BaseClass{
	@Test
	public void addingSmartPhoneToCart() {
		ExtentTest test=extent.createTest("Adding to Cart");
		basepage.getElectronics().click();
		test.pass("Electronics link clicked");
		ElectronicsPage elepage=new ElectronicsPage(driver);
		elepage.getCellphoneLink().click();
		test.pass("Cell phone link clicked");
		CellPhonesPage cellpage=new CellPhonesPage(driver);
		cellpage.getPhoneCover().click();
		test.pass("Clicked on Phone Cover");
		cellpage.getAddToCartButton().click();
		test.pass("Added to the cart");
	}
}
