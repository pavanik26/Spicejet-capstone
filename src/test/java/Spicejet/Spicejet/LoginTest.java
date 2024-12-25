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
public class LoginTest {

	WebDriver driver;
	Login loginPage;
	Browsersetup browserSetup;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Setup: Initialize the WebDriver
	@BeforeMethod
	public void setUp() {
		driver = BrowsersetupTest.driver; // Initialize WebDriver here
		loginPage = new Login(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	// Method to test login 
	public void testLogin() throws InterruptedException {

		loginPage.clickLoginButton();

		String mobile = "9177673612";
		String password = "India@12345";

		loginPage.enterLoginDetails(mobile, password);

		loginPage.submitLogin();
		WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[contains(@class, 'css-76zvg2 r-jwli3a r-ubezar r-1ozqkpa')])[1]")));
		Assert.assertTrue(accountElement.getText().contains("Hi"), "Login failed");

		// Print success message to the console
		System.out.println("Test passed! Login success with name: " + accountElement.getText());

	}

}
