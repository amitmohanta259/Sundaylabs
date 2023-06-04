package com.automation.automation.SeleniumWebdriver;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ActionsClassEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		
		WebElement account =  driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Laptop");
		Thread.sleep(1000);
		ac.moveToElement(account).build().perform();
		
	}

}
