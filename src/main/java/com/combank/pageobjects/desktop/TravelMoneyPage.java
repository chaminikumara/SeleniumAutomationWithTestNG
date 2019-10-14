package com.combank.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class TravelMoneyPage {
	private WebDriver driver;

	@FindBy(xpath = "//a[@class=\"log-on-text\"]")
	private WebElement loginBtn;
	@FindBy(xpath = "//h2[contains(text(),'A mix of cash and cards')]")
	private WebElement subTopicCashAndCards;

	public TravelMoneyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		@SuppressWarnings({ "deprecation", "unused" })
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(10, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * Navigate to log on.
	 */
	public void navigateLogOn() {
		loginBtn.click();
		//return new LogonPage(driver);
	}
	
	/**
	 * Verify Travel money page sub topics.
	 */
	public Boolean validatesubTopic(String topic) {
		String locateTitelText = subTopicCashAndCards.getText();
		return locateTitelText.contains(topic);
	}
	
}
