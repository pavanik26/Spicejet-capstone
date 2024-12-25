package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	// Locators for Login page
	By loginBtn = By.xpath("//div[contains(text(),'Login')]");
	By mobileNumber = By.xpath("//input[@type='number']");
	By passwordInput = By.xpath("//input[@type='password']");
	By logInBtn = By.xpath("(//div[@data-testid='login-cta'])");

	WebDriver driver;
	WebDriverWait wait;

	// Constructor to initialize WebElements
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	}

	// Method to click the Login button
	public void clickLoginButton() {

		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		login.click();

	}

	// Method to enter Login details
	public void enterLoginDetails(String mobile, String password) {

		WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
		number.sendKeys(mobile);
		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
		pwd.sendKeys(password);
	}

	// Method to submit Login
	public void submitLogin() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@data-testid='login-cta'])")).click();
		Thread.sleep(10000);

	}
}
