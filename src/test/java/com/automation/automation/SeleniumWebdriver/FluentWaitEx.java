package com.automation.automation.SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class FluentWaitEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		//Explicit Wait
		WebElement expected = driver.findElement(By.xpath("//div[@id='finish']/h4"));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(expected));
		System.out.println(expected.getText());
		
		
	}

}
