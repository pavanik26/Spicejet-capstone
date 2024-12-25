package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class BookingPageTest {

	WebDriver driver;
	BookingPage bookingPage;
	Browsersetup browserSetup;
	FlightSearchPage flightsearchPage;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Setup: Initialize the WebDriver
	@BeforeMethod
	public void setUp() {
		// Initialize Browsersetup and get the WebDriver
		driver = BrowsersetupTest.driver; // Initialize WebDriver here
		bookingPage = new BookingPage(driver);
		flightsearchPage = new FlightSearchPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test
	// Method to test one-way flight search and verify booking confirmation message
	public void enterBookingDetails() throws InterruptedException {
		WebElement oneWayTrip = driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']"));
		wait.until(ExpectedConditions.elementToBeClickable(oneWayTrip));
		oneWayTrip.click();
		flightsearchPage.onewayTrip("Delhi", "Mumbai");
		flightsearchPage.clickSearchButton();
		bookingPage.enterContactDetailsForBooking("Mrs", "pavani", "k", "9177673612", "pavani.kashana26@gmail.com");
		bookingPage.enterPaymentInformation("1234 5678 0912 3456", "pavani", "10", "25", "321");

		// Wait for the results to load and verify they are displayed
		Assert.assertTrue(bookingPage.isBookingConfirmationDisplayed(), "Booking not successful");
		System.out.println("Booking Successfull for selection made");
		Thread.sleep(4000);
	}

}
