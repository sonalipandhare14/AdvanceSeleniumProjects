package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {

	public ElectronicsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Camera, photo")
	private WebElement cameraPhotoLink;
	
	@FindBy(partialLinkText = "Cell phones")
	private WebElement cellphoneLink;

	public WebElement getCameraPhotoLink() {
		return cameraPhotoLink;
	}

	public WebElement getCellphoneLink() {
		return cellphoneLink;
	}
}
