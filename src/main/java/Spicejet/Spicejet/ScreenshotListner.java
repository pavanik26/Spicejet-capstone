package Spicejet.Spicejet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class ScreenshotListner implements ITestListener {

	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		// Use the WebDriver from Browsersetup class
		driver = Browsersetup.driver;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// This method will be triggered when the test fails
		try {
			// Take screenshot
			TakesScreenshot ts = (TakesScreenshot) Browsersetup.driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			// Define the location where screenshot will be saved
			String screenshotFolder = "C:\\Users\\Admin\\eclipse-workspace\\Spicejet\\screenshots";

			// Ensure the directory exists
			File folder = new File(screenshotFolder);
			if (!folder.exists()) {
				folder.mkdirs(); // Create the directory if it doesn't exist
			}

			// Create a screenshot path using File.separator for cross-platform support
			String screenshotPath = screenshotFolder + File.separator + result.getName() + "_failure.png";
			File destination = new File(screenshotPath);

			// Save the screenshot to the destination path
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken for failed test: " + result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
