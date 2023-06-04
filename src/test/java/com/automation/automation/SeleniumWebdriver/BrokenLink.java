package com.automation.automation.SeleniumWebdriver;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.scrollingElement.scrollBy(0,1500)");
		WebElement footer = driver.findElement(By.cssSelector("div[id='gf-BIG'] table tbody"));
		SoftAssert asset =  new SoftAssert();
		List<WebElement> allFooterLinksElements = footer.findElements(By.tagName("a"));	
		for(WebElement allFooterLinksElement : allFooterLinksElements) {
			HttpURLConnection conn = (HttpURLConnection) new URL(allFooterLinksElement.getAttribute("href")).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int response = conn.getResponseCode();
			System.out.println(response);
			asset.assertTrue(response>400,conn.getURL()+" is a broken link");
//			if(response >= 400 ) {
//				System.out.println(conn.getURL()+" is a broken link");
//				
//			}else {
//				System.out.println(conn.getURL()+" is not a broken link");
//			}
		}
		asset.assertAll();
		driver.close();
	}

}
