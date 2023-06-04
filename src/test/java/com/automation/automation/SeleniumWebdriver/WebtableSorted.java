package com.automation.automation.SeleniumWebdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class WebtableSorted {
	ChromeDriver driver;
	@BeforeTest
	public void initializeDriver() {
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
	}
	@Test
	public void sortTable() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
