package com.automation.automation.SeleniumWebdriver;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class CartAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String items[] = {"Cucumber","Beetroot"};
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		for(String item :items ) {
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//div[@class='product']/h4[contains(.,'"+item+"')]/following-sibling::div/a[@class='increment']"));
			System.out.println(element.toString());
			for(int i=0;i<3;i++) {
				element.click();
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='product']/h4[contains(.,'"+item+"')]/following-sibling::div[2]/button")).click();
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
	}

}
