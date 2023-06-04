package com.automation.automation.SeleniumWebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class OptionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options); 
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle().toString());
	}

}
