package com.automation.sundaylabs.SundayLab;
import org.testng.annotations.Test;

import com.main.sundaylabs.designpattern.*;
import com.main.sundaylabs.library.AppLibrary;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class EndtoEndTest {
	@BeforeTest
	public void initialize() {
		AppLibrary.initializeDriver();
	}
	@Test
	public void Login() throws InterruptedException {
		Thread.sleep(1000);
		Login l = new Login(AppLibrary.driver);
		l.performLoginOperations();
	}
	
	@Test
	public void ProfilePage() throws InterruptedException {
		Thread.sleep(10000);
		ViewProfile v = new ViewProfile(AppLibrary.driver);
		v.AccountInfo();
	}
	
	
	@AfterTest
	public void close() {
		AppLibrary.driver.close();
	}
	
}	
