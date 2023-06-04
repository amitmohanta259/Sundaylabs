package com.automation.automation.SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ScopeWebDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.tagName("a")).getSize();
		System.out.println(driver.findElement(By.tagName("a")).getSize()) ;
		
	}

}
