package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateFields {

	WebDriver driver;
	WebDriverWait wait;
	ValidateFields validateFieldsPage;

	// Locators for the validate tabs
	By checkInTab = By.xpath("//div[@data-testid='check-in-horizontal-nav-tabs']"); 
	By flightStatusTab = By.xpath("//div[@data-testid='flight status-horizontal-nav-tabs']"); 
	By manageBookingTab = By.xpath("//div[@data-testid='manage booking-horizontal-nav-tabs']"); 

	// Constructor to initialize WebElements
	public ValidateFields(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
 
	//Method to validate Check in tab
	public String validateCheckInField() {
		WebElement checkinText = driver.findElement(checkInTab);
		checkinText.click();
		return checkinText.getText();
	}

	//Method to validate Flight status tab
	public String validateFlightStatusField() {
		WebElement status = driver.findElement(flightStatusTab);
		status.click();
		return status.getText();
	}

	//Method to validate manage booking tab
	public String manageBookingField() {
		WebElement booking = driver.findElement(manageBookingTab);
		booking.click();
		return booking.getText();
	}

}
