package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListner.class)
public class SignupTest {

	WebDriver driver;
	Signup signupPage;
	Browsersetup browserSetup;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Setup: Initialize the WebDriver
	@BeforeMethod
	public void setUp() {
		driver = BrowsersetupTest.driver; // Initialize WebDriver here
		signupPage = new Signup(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	// Method to test sign up page
	public void testSignup() {
		// Save the current window handle before opening the signup page
		String originalWindowHandle = driver.getWindowHandle();

		signupPage.clickSignupButton();
		
		// Fill out the signup form with test data
		String title = "Mrs";
		String fname = "Pavani";
		String lname = "pk";
		// String DOB = "2024-12-25";
		String phone = "9177673612";
		String email = "pavani.kashana26@gmail.com";
		String password = "India@12345";
		String cpassword = "India@12345";

		signupPage.fillSignupForm(title, fname, lname, phone, email, password, cpassword);

		// Submit the signup form
		signupPage.submitSignupForm();

		// Wait for the confirmation page to load
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Validate if the signup was successful
		WebElement accountElement = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		if (accountElement.isDisplayed()) {
			System.out.println("Signup Success!!!");
		}

		// Switch back to the original tab
		signupPage.switchToOriginalTab(originalWindowHandle);
	}

}
