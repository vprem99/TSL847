package day5NG;

import org.testng.annotations.Test;

import utils.ExcelReader;
import utils.HelperFunctions;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ParaMetrization {
	WebDriver driver;

	@Test(dataProvider = "dp")
	public void loginProcess(String un, String pwd) {
		System.out.println(un + " " + pwd);
		driver.get("http://demo.frontaccounting.eu/");
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("user_name_entry_field")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("SubmitUser")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Date date = new Date();
			String newDate = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
			HelperFunctions.getSnap("Login" + newDate + ".png");
		}
	}

	@DataProvider
	public Object[][] dp() { // Rows Col
		Object data[][] = new Object[4][2];
		/*
		 * data[0][0] = "admin"; data[0][1] = "admin123"; data[1][0] = "hr"; data[1][1]
		 * = "hr123"; data[2][0] = "demouser"; data[2][1] = "password"; data[3][0] =
		 * "xyz"; data[3][1] = "xyz123"; data[4][0] = "demo"; data[4][1] = "demo123";
		 */
		ExcelReader ex = new ExcelReader("C:\\Users\\Bhajan\\Desktop\\SelJars\\data.xlsx");
		for (int i = 1; i < ex.getRowNum("Sheet1"); i++) {
			data[i - 1][0] = ex.getCellData("Sheet1", i, 0);
			data[i - 1][1] = ex.getCellData("Sheet1", i, 1);
		}
		return data;
	}

	@BeforeTest // Pre-Conditions
	@Parameters("browser")
	public void beforeTest(String browser) {
		if (browser.equals("firefox"))
			driver = HelperFunctions.setBrowser("firefox");
		else if (browser.equals("chrome"))
			driver = HelperFunctions.setBrowser("chrome");
		else
			driver = HelperFunctions.setBrowser("chrome");
	}

	@AfterTest // Post- COndition
	public void afterTest() {
		driver.quit();
	}
}
