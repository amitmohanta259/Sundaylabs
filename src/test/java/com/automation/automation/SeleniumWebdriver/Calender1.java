package com.automation.automation.SeleniumWebdriver;

import org.apache.velocity.runtime.directive.Parse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Calender1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[@class='elementor-button-text']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		String input = "June 5, 2025";
		String[] inputArray = input.toString().split(",");
		String yearString = inputArray[1].trim().toString();
		String dayString = inputArray.toString().split(" ")[1].toString();
		String monString = inputArray.toString().split(" ")[0].toString();
		System.out.println(yearString);
		String year =driver.findElement(By.xpath("//input[@class='numInput cur-year']")).getText(); 
		System.out.println(year);
		Integer yearInt =Integer.parseInt(yearString); 
		if(Integer.parseInt(year) > Integer.parseInt(yearString)) {
			driver.findElement(By.xpath("//span[@class='arrowDown']")).click();
		}else if(Integer.parseInt(year) < Integer.parseInt(yearString)) {
			driver.findElement(By.xpath("//span[@class='arrowUp']")).click();
		}
	}

}
