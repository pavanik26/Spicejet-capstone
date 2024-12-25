package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class ValidateFieldsTest {

	WebDriver driver;
	BookingPage bookingPage;
	Browsersetup browserSetup;
	ValidateFields validateFieldsPage;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Setup: Initialize the WebDriver
	@BeforeMethod
	public void setUp() {
		driver = BrowsersetupTest.driver; // Initialize WebDriver here
		validateFieldsPage = new ValidateFields(driver);	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test
	//Method to test check-in, flight status and manage booking tabs
	public void validateTabs() throws InterruptedException {
		Thread.sleep(4000);
		String checkinText = validateFieldsPage.validateCheckInField();
		Assert.assertEquals(checkinText, "Check-In");
		System.out.println("Check-In tab displayed successfully");
		String status = validateFieldsPage.validateFlightStatusField();
		Assert.assertEquals(status, "Flight Status");
		System.out.println("Flight status tab displayed successfully");
		String booking = validateFieldsPage.manageBookingField();
		Assert.assertEquals(booking, "Manage Booking");
		System.out.println("Manage Booking tab displayed successfully");

	}

}
