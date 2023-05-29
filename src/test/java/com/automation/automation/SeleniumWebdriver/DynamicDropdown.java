package com.automation.automation.SeleniumWebdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		Thread.sleep(2000);
		WebElement toLoactions = driver.findElement(By.xpath("(//td[@class='mapbg'])[2]"));
		List<WebElement> elements = toLoactions
				.findElements(By.xpath("(//td[@class='mapbg'])[2]/div[3]/div/div/ul/li/a"));
		for (WebElement ele : elements) {
			System.out.println(ele.getText());
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VTZ']"))
				.click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Div1'] //button[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last'] //a[text()='15']"))
				.click();
		// driver.close();

	}
}
