package com.automation.automation.SeleniumWebdriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class HandleChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowId = driver.getWindowHandles();
		//if multiple child window then //fetch parent using getWindowHandle and iterate the rest windowId
		//String parentId = driver.getWindowHandle();
		//If single child
		Iterator<String> it = windowId.iterator();
		String parentId =it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='im-para red']/strong/a"))));
		String username = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
		driver.close();
		//driver.switchTo().window(parentId);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		
	}

}
