package com.main.automation.library;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverIntialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.setProperty("websriver.chrome.driver", "locations");
		WebDriver driver = new ChromeDriver();
		driver.get("www.google.com"); 
		*/
		
		
		//Chrome Driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Close method will close the current window 
		
		
		
		
		//Firefox Driver
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver1 = new FirefoxDriver();
//		driver1.manage().window().fullscreen();
//		driver1.get("https://en.wikipedia.org/wiki/Facebook");
//		//Quit will close all associated window If multiple windows get opened the it will close all the window
//		driver1.close();
		
		//Edge Driver
//		System.setProperty("webdriver.http.factory", "jdk-http-client");
//		WebDriverManager.edgedriver().setup();
//		EdgeDriver driver2 = new EdgeDriver();
//		driver2.manage().window().maximize();
//		System.out.println(driver2.manage().window().getSize());
//		driver2.manage().window().setSize(new Dimension(1024, 768));
//		System.out.println(driver.manage().getCookies().toString());
//		driver2.get("https://en.wikipedia.org/wiki/Facebook");
//		driver2.quit();
//		
	}

}
