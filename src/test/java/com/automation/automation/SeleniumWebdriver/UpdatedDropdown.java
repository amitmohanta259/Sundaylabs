package com.automation.automation.SeleniumWebdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int adultCount = 5,childCount =3,infantCount=1;
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		List<WebElement> dropDownElement =  driver.findElements(By.xpath("//div[@id='divpaxOptions']/div"));
		for(WebElement option:dropDownElement) {
			System.out.println(option.getText().split("\n")[0]);
			if(option.getText().split("\n")[0].equals("ADULT")) {
				Thread.sleep(2000);
				for(int i=0;i<adultCount;i++) {
					driver.findElement(By.id("hrefIncAdt")).click();
				}
					
			}if(option.getText().split("\n")[0].equals("CHILD")) {
				for(int i=0;i<childCount;i++) {
					driver.findElement(By.id("hrefIncChd")).click();	
				}
				    
			}if(option.getText().split("\n")[0].equals("INFANT")) {
				for(int i=0;i<infantCount;i++) {
					driver.findElement(By.id("hrefIncInf")).click();
				}
					
			}
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.close();
		
	}

}
