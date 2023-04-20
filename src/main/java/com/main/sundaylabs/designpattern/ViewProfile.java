package com.main.sundaylabs.designpattern;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	@FindBy(xpath = "//div[text()='PAN']//parent::div//following-sibling::div//div//div[2]")
	WebElement panPopUpButton;
	
	@FindBy(xpath = "//div[text()='Verify PAN Card']")
	WebElement popUpHeading;

	@FindBy(xpath = "//input[@placeholder='Enter you PAN Card Number']")
	WebElement panCardInputField;
	
	@FindBy(xpath = "(//button[@class='custom-button '])[3]")
	WebElement verifyPanSubmitButton;
	
	@FindBy(xpath = "//div[@class='field-items modal-text']/p")
	WebElement validationMessage;
	
	public void AccountInfo() throws InterruptedException{
		profile.click();
		viewProfile.click();
		Thread.sleep(2000);
		
	}
	
	public void VerifyPanCardPopWindow() throws InterruptedException {
		//Boolean status=false;
		Thread.sleep(1000);
		panPopUpButton.click();
		Thread.sleep(3000);
		
	}
	
	public String verifyPanCardWithInValidPan() throws InterruptedException {
		panCardInputField.sendKeys("QWERT1234K");
		Thread.sleep(1000);
		verifyPanSubmitButton.click();
		return validationMessage.getText();
	}
	
	public String verifyPanCardWithValidPan() throws InterruptedException {
		panCardInputField.sendKeys("ALWPG5809L");
		Thread.sleep(1000);
		verifyPanSubmitButton.click();
		return validationMessage.getText();
	}
	
	
	
	
}
