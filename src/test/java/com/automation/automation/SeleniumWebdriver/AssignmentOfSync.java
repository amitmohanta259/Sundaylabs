package com.automation.automation.SeleniumWebdriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class AssignmentOfSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='user']/following-sibling::span")));
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		Select dropdown = new Select(driver.findElement(By.tagName("select")));
		dropdown.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		//
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("card")));
		List<WebElement> allMobile  = driver.findElements(By.className("card"));
		for(int i=0;i<allMobile.size();i++) {
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
		WebElement checkout = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", checkout);
		checkout.click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-success']"))));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("india");
		List<WebElement>countrys =  driver.findElements(By.xpath("//div[@class='suggestions'] //li/a"));
		for(WebElement country: countrys) {
			if(country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@class='btn btn-success btn-lg' and @value='Purchase']")).click();
		driver.close();
	}

}
