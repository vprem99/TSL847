package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentExample {
	WebDriver driver;
	ExtentReports extent;

	@Test
	public void titleTest() {
		extent = new ExtentReports();
		// Specifying name of File & Loading HTML Reporter
		extent.attachReporter(new ExtentHtmlReporter("ExtentReport.html"));
		ExtentTest titleTestLog = extent.createTest("Title Verification");
		titleTestLog.info("Opening Title");
		driver.get("http://demo.frontaccounting.eu/");
		titleTestLog.info("Fetching current page Title");
		String title = driver.getTitle();
		titleTestLog.info("Verifying Title");
		Assert.assertEquals(title, "FrontAccounting 2.4.4 - Login");
		titleTestLog.pass("Title Verification is Passed");
	}

	@Test(dependsOnMethods = "titleTest")
	public void LoginTest() {
		ExtentTest LoginTestLog = extent.createTest("Login Verification");
		LoginTestLog.info("Clearing UserName & Password fields");
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("password")).clear();

		LoginTestLog.info("Typing UserName & Password");
		driver.findElement(By.name("user_name_entry_field")).sendKeys("demouser");
		driver.findElement(By.name("password")).sendKeys("password");
		LoginTestLog.info("Doing Login");
		driver.findElement(By.name("SubmitUser")).click();
		String title = driver.getTitle();
		LoginTestLog.info("Verifying Title");
		Assert.assertEquals(title, "Main Menu");
		LoginTestLog.pass("Login is successful & Test is Pass");
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		extent.flush(); // Write report at desired location
	}

}
