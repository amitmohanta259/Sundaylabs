package com.automation.automation.SeleniumWebdriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SyncExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] itemsListToAddToCart = {"Cucumber","Brocolli","Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		SyncExample.addItem(driver, itemsListToAddToCart);
		SyncExample.clickAddToCart(driver);
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='promoInfo']"))));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText()); 
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement dropdown = driver.findElement(By.tagName("select"));
		Select sc = new Select(dropdown);
		sc.selectByValue("India");
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.close();
	}
	
	public static void addItem(WebDriver driver, String[] items) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(items);
			if (itemsNeededList.contains(formattedName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == items.length)
				{
					break;
				}
			}
		}
	}
	
	public static void clickAddToCart(WebDriver driver) {
		driver.findElement(By.cssSelector("a[class='cart-icon'] img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		
	}
	
	
	
}
