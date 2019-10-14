package com.combank.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.combank.utils.Utils;

public class LogonPage {
	
	private WebDriver driver;
	@FindBy(xpath = "//input[@id='txtMyClientNumber_field']")
	private WebElement clientNumber;
	@FindBy(xpath = "//input[@id='txtMyPassword_field']")
	private WebElement passWord;
	@FindBy(xpath = "//input[@id='btnLogon_field']")
	private WebElement loginBtn;
	
	public LogonPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

		@SuppressWarnings({ "deprecation", "unused" })
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(10, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	
	/**
	 * Log in
	 */
	public void Login(String clientNo, String password) {
		clientNumber.sendKeys(clientNo);
		passWord.sendKeys(password);
		loginBtn.click();
		//return new CustomerPortalPage(driver);
	}
}
