package Spicejet.Spicejet;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
 import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {
	

	   // Locators for SignUp page
	    By signupBtn =  By.xpath("//div[contains(text(),'Signup')]"); //	    
	    By titleDropdown = By.xpath("//select[@class='form-control form-select ']");    
	    By txtFirstName = By.xpath("//input[@id='first_name']"); 	
		By txtLastName = By.xpath("//input[@id='last_name']"); 
		By countryDropdown = By.xpath("//select[@class='form-control form-select']");
	    By dateCalender = By.xpath("//input[@id='dobDate']");
	    
	    By txtDatOfBirth = By.xpath("//div[@aria-label='Choose Wednesday, November 29th, 2006']");
	    By dateIcon = By.xpath("//img[@alt='date']");
	    
	    By txtMobileNumber = By.xpath("//input[@placeholder='+91 01234 56789']");
	    By txtEmail = By.xpath("//input[@id='email_id']");    
    
	    By txtPwd = By.xpath("//input[@id='new-password']");
   
	    By txtConfirmPwd = By.xpath("//input[@id='c-password']");
    
	    By chkTermAndConditions = By.xpath("//input[@id='defaultCheck1']");
	    By submitBtn = By.xpath("//button[normalize-space()='Submit']");
	   
	    
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    // Constructor to initialize WebElements
	    public Signup(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize after driver is assigned
	    }
	    
	    // Method to click the sign up button and handle new tab
	    public void clickSignupButton() {
	        // Save the current window handle
	        String currentWindowHandle = driver.getWindowHandle();
            
	        WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
	        // Click on the signup button (this will open a new tab)
	        signUp.click();

	        // Wait for the new tab to open and switch to it
	        Set<String> windowHandles = driver.getWindowHandles();
	        for (String handle : windowHandles) {
	            if (!handle.equals(currentWindowHandle)) {
	                driver.switchTo().window(handle); // Switch to the new tab
	                break;
	            }
	        }
	    }
	
	    // Method to fill the sign up form
	    public void fillSignupForm(String title, String fname, String lname, String phone, String email, String password, String cpassword) {

	    	WebElement tlt = wait.until(ExpectedConditions.visibilityOfElementLocated(titleDropdown));
	        tlt.sendKeys(title);
	        WebElement textfname = wait.until(ExpectedConditions.visibilityOfElementLocated(txtFirstName));
	        textfname.sendKeys(fname);
	        WebElement textlname = wait.until(ExpectedConditions.visibilityOfElementLocated(txtLastName));
	        textlname.sendKeys(lname);;
	    	WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(dateCalender));
	        calender.click();
	    	WebElement birthDate = wait.until(ExpectedConditions.visibilityOfElementLocated(txtDatOfBirth));
	    	birthDate.click();
	    	WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(txtMobileNumber));
		    mobile.sendKeys(phone);
		    
		    WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		    // Scroll the element into view
		    // Use Actions class to simulate typing
	        Actions actions = new Actions(driver);
	        actions.moveToElement(emailAddress).click().sendKeys(email).perform();
		    WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPwd));
		    pwd.sendKeys(password);
		    WebElement cpwd = wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmPwd));
		    cpwd.sendKeys(cpassword);	    	
	    	WebElement chkTerms = wait.until(ExpectedConditions.visibilityOfElementLocated(chkTermAndConditions));
	    	chkTerms.click();
	 	    }
	    
	    // Method to submit sign up form
	    public void submitSignupForm() {
	        //submitBtn.click();
	        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
	    	submit.click();
	    }
	  	
	    
	   // Optionally, method to switch back to the original tab
	    public void switchToOriginalTab(String originalWindowHandle) {
	        driver.switchTo().window(originalWindowHandle);
	    }
	
}
