package com.automation.automation.SeleniumWebdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SuggestionDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("!@#");
		Thread.sleep(2000);
		List<WebElement> suggestionElement =  driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		if(suggestionElement.size()>0) {
			for(WebElement sug : suggestionElement) {
				if(sug.getText().equalsIgnoreCase("India")) {
					sug.click();
					break;
				}else {
					System.out.println("Option "+sug.getText()+" did not match India");
					continue;
				}
			}
		}else {
			System.out.println("No Suggestion");
		}
		
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		driver.close();
	}

}
