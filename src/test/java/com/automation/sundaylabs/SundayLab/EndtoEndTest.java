package com.automation.sundaylabs.SundayLab;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.sundaylabs.designpattern.Signup;
import com.main.sundaylabs.library.AppLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEndTest {
	@BeforeTest
	public void initialize() {
		AppLibrary.initializeDriver();
	}
	@Test
	public void signup() throws InterruptedException {
		Thread.sleep(1000);
		Signup signup = new Signup(AppLibrary.driver);
		signup.clickSignupButton();
		
	}
	@AfterTest
	public void close() {
		//AppLibrary.driver.close();
	}
	
}	
