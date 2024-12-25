package Spicejet.Spicejet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	
	// Locators for the flight search page
 	By flightsTab = By.xpath("//div[@data-testid='Flights-horizontal-nav-tabs']"); 
    By roundTripOption = By.xpath("//div[@data-testid='round-trip-radio-button']");  
    By originInput = By.xpath("(//input[@type='text'])[1]"); 
    By destinationInput = By.xpath("(//input[@type='text'])[2]");
    By oneWayDateInput = By.xpath("//div[@data-testid='undefined-month-December-2024']//div[@data-testid='undefined-calendar-day-27']");  // Update with correct element ID
    By roundTripDateInput = By.xpath("//div[@data-testid='undefined-month-December-2024']//div[@data-testid='undefined-calendar-day-29']");  // Update with correct element ID
    By returnDateInput = By.xpath("//div[@data-testid='undefined-month-December-2024']//div[@data-testid='undefined-calendar-day-31']"); 
    By passengersDropdown = By.xpath("//div[contains(text(),'Passengers')]");    
    By adult = By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']");
    By children = By.xpath("//div[@data-testid='Children-testID-plus-one-cta']");
    By searchButton = By.xpath("//div[@data-testid='home-page-flight-cta']"); 
    By searchResults = By.xpath("(//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-b5h31w r-1ah4tor r-tvv088'])[1]"); 
    
    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    public void navigateToFlightsTab() {
   
    	WebElement flightsField = driver.findElement(flightsTab);
    	flightsField.click();
     }
    
    
    // Search for One way trip flights
    public void onewayTrip(String origin, String destination) {
    	WebElement originField = driver.findElement(originInput);
    	wait.until(ExpectedConditions.elementToBeClickable(originField));
        originField.clear();
        originField.sendKeys(origin);
        WebElement destinationField = driver.findElement(destinationInput);
        wait.until(ExpectedConditions.elementToBeClickable(destinationField));
        destinationField.clear();
        destinationField.sendKeys(destination);
        WebElement departureDateField = driver.findElement(oneWayDateInput);
        wait.until(ExpectedConditions.elementToBeClickable(departureDateField));
        departureDateField.click();
        WebElement passengersDropdownElement = driver.findElement(passengersDropdown);
        wait.until(ExpectedConditions.visibilityOf(passengersDropdownElement));
        passengersDropdownElement.click();
        
    }
    
 // Search for Round trip flights
    public void roundTrip(String origin, String destination) {
    
    	WebElement roundTripRadio = driver.findElement(roundTripOption);
    	wait.until(ExpectedConditions.elementToBeClickable(roundTripRadio));
    	roundTripRadio.click();
        WebElement originField = driver.findElement(originInput);
        wait.until(ExpectedConditions.elementToBeClickable(originField));
        originField.sendKeys(origin);        
        WebElement destinationField = driver.findElement(destinationInput);
        wait.until(ExpectedConditions.elementToBeClickable(destinationField));
        destinationField.clear();
        destinationField.sendKeys(destination);
        WebElement roundTripDateField = driver.findElement(roundTripDateInput);
        wait.until(ExpectedConditions.elementToBeClickable(roundTripDateField));
        //roundTripDateField.clear();
        roundTripDateField.click();
        WebElement returnDateField = driver.findElement(returnDateInput);
        wait.until(ExpectedConditions.elementToBeClickable(returnDateField));
        returnDateField.click();
        WebElement passengersDropdownElement = driver.findElement(passengersDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(passengersDropdownElement));
        passengersDropdownElement.click();
       
    }

    // Click the Search button
    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }

    // Wait for the search results to load
    public boolean isSearchResultsDisplayed() {
        try {
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
            return results.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
