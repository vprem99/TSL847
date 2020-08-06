package day5NG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.HelperFunctions;

public class FirstNG_Test {
	WebDriver driver;

	@Test(priority=1,description = "Verifying title of Google Home Page")
	public void titleTest() {
		driver.get("http://google.com");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google India", "Title not Matched"); // Does Comparison between Expected & Actual
	}

	@Test(priority=2,description = "Verifying search field")
	public void searchTest() {
		WebElement E = driver.findElement(By.name("q"));
		Assert.assertEquals(E.isDisplayed(), true); // Does Comparison between Expected & Actual
		Assert.assertEquals(E.isEnabled(), true); // Does Comparison between Expected & Actual
		Assert.assertEquals(E.getAttribute("type"), "text"); // Does Comparison between Expected & Actual
	}

	@BeforeTest // Pre-Conditions
	public void beforeTest() {
		driver = HelperFunctions.setBrowser("chrome");
	}

	@AfterTest // Post- COndition
	public void afterTest() {
		driver.quit();
	}
}
