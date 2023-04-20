package com.main.sundaylabs.designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProfile{
	WebDriver driver;
	
	public ViewProfile(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='user-name']")
	WebElement profile; 
	
	@FindBy(xpath = "//a[@href='/profile']")
	WebElement viewProfile;
	
	@FindBy(xpath = "//button/div[text()='Upload Documents']")
	WebElement uploadDoc;
	
//	@FindBy(xpath = "//button[@class='custom-button ']//div[contains(text(),'Login')]")
//	WebElement uploadDocument;
//	
	
	public void AccountInfo() throws InterruptedException{
		profile.click();
		viewProfile.click();
		Thread.sleep(2000);
		uploadDoc.click();
	}
	
}
