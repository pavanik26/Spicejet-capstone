package Spicejet.Spicejet;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class FlightSearchPageTest {

	WebDriver driver;
	FlightSearchPage flightsearchPage;
	Browsersetup browserSetup;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Setup: Initialize the WebDriver
	@BeforeMethod
	public void setUp() {
		driver = BrowsersetupTest.driver; 
		flightsearchPage = new FlightSearchPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	// Method to test one way flight search and verify results
	public void searchOneWayFlight() throws InterruptedException {
		// Perform one-way flight search
		Thread.sleep(2000);
		flightsearchPage.navigateToFlightsTab();
		flightsearchPage.onewayTrip("Hyderabad", "Delhi");
		flightsearchPage.clickSearchButton();

		// Wait for the results to load and verify they are displayed
		Assert.assertTrue(flightsearchPage.isSearchResultsDisplayed(),
				"Search results not displayed for one-way flight.");
		System.out.println("One-way flight search completed successfully.");
		Thread.sleep(4000);
		driver.navigate().back();
	}

	@Test
	// Method to test round trip flight search and verify results
	public void searchRoundTripFlight() throws InterruptedException {
		Thread.sleep(5000);
		// Perform round-trip flight search
		flightsearchPage.roundTrip("Delhi", "Chennai");
		Thread.sleep(5000);
		flightsearchPage.clickSearchButton();

		// Wait for the results to load and verify they are displayed
		Assert.assertTrue(flightsearchPage.isSearchResultsDisplayed(),
				"Search results not displayed for round-trip flight.");
		System.out.println("Round-Trip flight search completed successfully.");
		Thread.sleep(4000);
		driver.navigate().back();

	}

}
