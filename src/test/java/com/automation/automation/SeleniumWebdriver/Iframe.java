package com.automation.automation.SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement dragable =  driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropable =driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions ac = new Actions(driver);
		ac.dragAndDrop(dragable, dropable).build().perform();
		driver.close();
	}

}
