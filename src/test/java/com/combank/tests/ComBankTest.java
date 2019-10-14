package com.combank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.combank.pageobjects.desktop.ComBankHomePage;
import com.combank.pageobjects.desktop.TravelMoneyPage;
import com.combank.utils.Utils;


public class ComBankTest {
	@Test
	@Parameters({ "browser", "travelMoneySubTopic", "clientNo", "password"  })
	public void Test(@Optional("chrome") String browser, String travelMoneySubTopic, String clientNo, String password)
		throws Exception {

			WebDriver driver = Utils.getDriver(browser);
			ComBankHomePage homePage = new ComBankHomePage(driver);
			TravelMoneyPage travelMoneyPage = new TravelMoneyPage(driver);

			SoftAssert softAssertion= new SoftAssert();
			
			travelMoneyPage = homePage.gotoTravelMoneyPage();
			// Assert search result page title text.
			softAssertion.assertTrue(travelMoneyPage.validatesubTopic(travelMoneySubTopic));
			
			travelMoneyPage.navigateLogOn();

			driver.quit();
	}
}
