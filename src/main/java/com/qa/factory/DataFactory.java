package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFactory {
	
	public WebDriver driver;
	
	// ThreadLocal for parallel Testing
	// This method is used to initilize the ThreadLocal driver on the basis of given browser
	
	public static ThreadLocal<WebDriver> tlDriver =  new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Broswer Value is: "+browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}
		else {
			
			System.out.println("Please pass the correct browser value: "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	// This is used to get the driver with ThreadLocal
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
