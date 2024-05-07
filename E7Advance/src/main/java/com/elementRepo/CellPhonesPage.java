package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CellPhonesPage extends BasePage {

	public CellPhonesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(partialLinkText = "Smartphone")
	private WebElement smartPhone;

	public WebElement getSmartPhone() {
		return smartPhone;
	}	
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartButton;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	@FindBy(partialLinkText = "Phone Cover")
	private WebElement phoneCover;

	public WebElement getPhoneCover() {
		return phoneCover;
	}
}
