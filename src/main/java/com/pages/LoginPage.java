package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	// 1. By Locator OR OR
	
	private By emailID = By.id("username");
	private By passID = By.id("password");
	private By signInButton = By.name("login");
	private By forGotPassLink = By.xpath("//a[@href=\"https://practice.automationtesting.in/my-account/lost-password/\"]");

	// 2. Constructor of the page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// 3. Page actions : Feature (Behavior) of the page form of the methods
	
	public String getLoginTitle() {
		
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExit() {
		
		return driver.findElement(forGotPassLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		
		driver.findElement(emailID).sendKeys(userName);
	}
	
	public void enterUserPassword(String userPass) {
		
		driver.findElement(passID).sendKeys(userPass);
	}
	
	public void clickLoginBtn() {
		driver.findElement(signInButton).click();
	}}
