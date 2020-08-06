package utils;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	public WebDriver driver;
	public Properties prop;
	@BeforeTest // Pre-Conditions
	public void beforeTest() throws Exception {
		prop = new Properties();
		prop.load(new FileInputStream(".\\src\\test\\resources\\files\\settings.property"));
		driver = HelperFunctions.setBrowser(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(prop.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}

	@AfterTest // Post- COndition
	public void afterTest() {
		// driver.quit();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Date date = new Date();
			String newDate = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
			HelperFunctions.getSnap("Login" + newDate + ".png");
		}
	}
}