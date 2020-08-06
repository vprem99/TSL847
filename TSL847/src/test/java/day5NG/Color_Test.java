package day5NG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.HelperFunctions;

public class Color_Test {
	WebDriver driver;

	@Test(description = "Checking Back-ground Color of Submit button")
	public void verifyColor() {
		driver.get("http://blazedemo.com");

		WebElement E = driver.findElement(By.xpath("//*[@value='Find Flights']"));
		// Getting Current| Actual Color of Button
		String backColor = E.getCssValue("background-color");
		System.out.println(backColor);
		// Converting rgb value to hex value
		String hexBackColor=Color.fromString(backColor).asHex();
		System.out.println(hexBackColor);
		//Comparing HexValue of Color
		Assert.assertEquals(hexBackColor, "#006dc6" ,"Color Code not matched");
	}

	@BeforeTest
	public void beforeTest() {
		driver = HelperFunctions.setBrowser("chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		driver.navigate().refresh();
		
	}
}
