package com.combank.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.combank.utils.Utils;

public class ComBankHomePage {
	
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='card guidance text']//p[contains(text(),'Tell me more')]")
	private WebElement travelmonyLink;


	public ComBankHomePage(WebDriver driver) {
		this.driver = driver;

		driver.get(Utils.getValueFromConf("commbank.url"));

		PageFactory.initElements(driver, this);

		@SuppressWarnings({ "deprecation", "unused" })
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(10, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	
	/**
	 * Navigate to Travel money page
	 */
	public TravelMoneyPage gotoTravelMoneyPage() {
		travelmonyLink.click();
		return new TravelMoneyPage(driver);
	}
}
