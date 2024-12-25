package Spicejet.Spicejet;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class BrowsersetupTest {

	public static WebDriver driver;
	Browsersetup browserSetup;

// This method will run before the entire test suite starts
	@BeforeSuite
	public void setUp() {
		// Initialize the browser setup
		browserSetup = new Browsersetup();
		// Set up the WebDriver and launch the browser
		driver = browserSetup.setUp();
	}

	// Test method: Launch SpiceJet website and validate title
	@Test
	public void testSpicejetLaunch() {
		// Open the SpiceJet website
		driver.get("https://www.spicejet.com/");

		// Validate that the page title contains "SpiceJet"
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("SpiceJet"), "Title does not contain expected text");

		// Print success message to the console
		System.out.println("Test passed! SpiceJet site opened with title: " + pageTitle);
	}

	// This method will run after the entire test suite has completed
	@AfterSuite
	public void tearDown() {
		// Close the browser after all tests are done
		if (driver != null) {
			driver.quit();
		}
	}
}
