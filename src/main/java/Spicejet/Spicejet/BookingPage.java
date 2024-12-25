package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage {

	WebDriver driver;
	WebDriverWait wait;
	FlightSearchPage flightsearchPage;

	// Locators for the flight booking page
	By continueButton = By.xpath("//div[@data-testid='continue-search-page-cta']"); 
	By titleDropdown = By.xpath("//div[@data-testid='title-contact-detail-card']"); 
	By contactFirstName = By.xpath("//input[@data-testid='first-inputbox-contact-details']"); 
	By contactLastName = By.xpath("//input[@data-testid='last-inputbox-contact-details']"); 
	By contactNumber = By.xpath("//input[@data-testid='contact-number-input-box']"); 
	By emailAddress = By.xpath("//input[@data-testid='emailAddress-inputbox-contact-details']");
	By primarycustomerCheckbox = By.xpath("//div[contains(text(),'I am flying as the primary passenger')]");
	By continueBooking = By.xpath("//div[@data-testid='traveller-info-continue-cta']");
	By continueAddOn = By.xpath("//div[@data-testid='add-ons-continue-footer-button']");
	By skipButton = By.xpath("(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-10x49cs r-1kfrs79 r-zhp00w r-1vzi8xi'])[1]");
	By cardNumber = By.xpath("//input[@id='card_number']");
	By cardName = By.xpath("//input[@id='name_on_card']");
	By expMonth = By.xpath("//input[@id='card_exp_month']");
	By expYear = By.xpath("//input[@id='card_exp_year']");
	By cvv = By.xpath("//input[@id='security_code']");
	By proceedPaymentButton = By.xpath("//div[@data-testid='common-proceed-to-pay']");
	By searchResults = By.xpath("(//span[@class='css-76zvg2 css-16my406 r-homxoj r-1s6pnzw'])[1]");
	By numberFrame = By.xpath("//iframe[@class='card_number_iframe']");
	By nameFrame =  By.xpath("//iframe[@class='name_on_card_iframe']");
	By monthFrame =  By.xpath("//iframe[@class='card_exp_month_iframe']");
	By yearFrame =  By.xpath("//iframe[@class='card_exp_year_iframe']");
	By securityFrame =  By.xpath("//iframe[@class='security_code_iframe']");
	
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		this.flightsearchPage = new FlightSearchPage(driver);
	}

	// Method to enter contact details in booking page
	public void enterContactDetailsForBooking(String title, String firstname, String lastname, String mobile, String email) throws InterruptedException {
		//Thread.sleep(5000);
		WebElement cntButton = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		cntButton.click();
		Thread.sleep(15000);
		//Below commented code need to be uncommented if this test is run without login
//		WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(titleDropdown));
//		// titleField.clear();
//		titleField.sendKeys(title);
//		WebElement fname = driver.findElement(contactFirstName);
//		// originField.clear();
//		fname.clear();
//		fname.sendKeys(firstname);
//		WebElement lname = driver.findElement(contactLastName);
//		lname.clear();
//		lname.sendKeys(lastname);
//		WebElement cNumber = driver.findElement(contactNumber);
//		cNumber.clear();
//		cNumber.sendKeys(mobile);
//		WebElement emailField = driver.findElement(emailAddress);
//		emailField.clear();
//		emailField.sendKeys(email);
		WebElement primaryCheckbox = driver.findElement(primarycustomerCheckbox);
		wait.until(ExpectedConditions.elementToBeClickable(primaryCheckbox));
		primaryCheckbox.click();
		WebElement continueBook = wait.until(ExpectedConditions.elementToBeClickable(continueBooking));
		continueBook.click();
		WebElement addOnContinue = wait.until(ExpectedConditions.elementToBeClickable(continueAddOn));
		addOnContinue.click();
		WebElement skipTextButton = wait.until(ExpectedConditions.elementToBeClickable(skipButton));
		skipTextButton.click();
	}

   // Method to enter payment details
	public void enterPaymentInformation(String cnumber, String cname, String month, String year, String code) throws InterruptedException {
		// Switch to a frame using XPath
		WebElement frameElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(numberFrame));
		driver.switchTo().frame(frameElement1);
		WebElement cardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
		cardNo.sendKeys(cnumber);
		driver.switchTo().defaultContent();
		WebElement frameElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFrame));
		driver.switchTo().frame(frameElement2);
		WebElement cName = wait.until(ExpectedConditions.visibilityOfElementLocated(cardName));
		cName.sendKeys(cname);
		driver.switchTo().defaultContent();
		WebElement frameElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(monthFrame));
		driver.switchTo().frame(frameElement3);
		WebElement mon = wait.until(ExpectedConditions.visibilityOfElementLocated(expMonth));
		// originField.clear();
		mon.sendKeys(month);
		driver.switchTo().defaultContent();
		WebElement frameElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(yearFrame));
		driver.switchTo().frame(frameElement4);
		WebElement eyear = wait.until(ExpectedConditions.visibilityOfElementLocated(expYear));
		eyear.sendKeys(year);
		driver.switchTo().defaultContent();
		WebElement frameElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(securityFrame));
		driver.switchTo().frame(frameElement5);
		WebElement securityCode = wait.until(ExpectedConditions.visibilityOfElementLocated(cvv));
		securityCode.sendKeys(code);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		WebElement paymentButton = wait.until(ExpectedConditions.elementToBeClickable(proceedPaymentButton));
		paymentButton.click();

	}

    // Wait for booking confirmation message
	public boolean isBookingConfirmationDisplayed() {
		try {
			WebElement successMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Booking Confirmed')]")));
			return successMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
