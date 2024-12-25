package Spicejet.Spicejet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Browsersetup {

	public static WebDriver driver; // Keep driver as a static variable for consistency

	// Method to initialize and return a WebDriver instance
	@BeforeSuite
	public WebDriver setUp() {
		// Use WebDriverManager to automatically set up ChromeDriver
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security", "--disable-site-isolation-trials");

		// Initialize ChromeDriver with the options
		driver = new ChromeDriver(options);

		// Optionally maximize the window 
		driver.manage().window().maximize();

		// Return the WebDriver instance
		return driver;
	}

	// Method to close the browser after all tests are executed
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			try {
				System.out.println("Waiting before closing browser...");
				Thread.sleep(5000); // Wait for 5 seconds before quitting
				driver.quit();
				System.out.println("Browser closed after all tests are completed.");
			} catch (Exception e) {
				System.out.println("An error occurred while closing the browser: " + e.getMessage());
			}
		}
	}

}
