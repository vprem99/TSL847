package day6Junit;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class Title_Test {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = HelperFunctions.setBrowser("chrome");
		System.out.println(driver + " In Setup");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		System.out.println(driver + " In Test");
		driver.get("http://google.com");
		assertEquals("Google", driver.getTitle());
		assertTrue(driver.getTitle().equals("Google"));
		assertTrue(driver.getTitle().contains("Google"));
		assertTrue(driver.getTitle().equalsIgnoreCase("google"));
		assertFalse(5 == 4);
		assertTrue(5 == 6);
		// In Junit 4 > First Expected ,Second Actual
		// In TestNG > First Actual ,Second Expected
	}
}