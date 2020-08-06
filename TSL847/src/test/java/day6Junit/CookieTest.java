package day6Junit;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class CookieTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = HelperFunctions.setBrowser("chrome");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// driver.quit();
	}

	@Test
	public void a_test() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Set<Cookie> allCookie = driver.manage().getCookies();
		for (Cookie C : allCookie) {
			System.out.println("Name of Cookie is " + C.getName());
			System.out.println("value of Cookie is " + C.getValue());
			System.out.println("Expiry of Cookie is " + C.getExpiry());
			System.out.println("Domain of Cookie is " + C.getDomain());
			System.out.println("Path of Cookie is " + C.getPath());
		}
	}

	@Test
	public void b_test() throws Exception {
		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(7000);
		Set<Cookie> allCookie = driver.manage().getCookies();
		for (Cookie C : allCookie) {
			System.out.println("Name of Cookie is " + C.getName());
			System.out.println("value of Cookie is " + C.getValue());
			System.out.println("Expiry of Cookie is " + C.getExpiry());
			System.out.println("Domain of Cookie is " + C.getDomain());
			System.out.println("Path of Cookie is " + C.getPath());
		}
	}

	@Test
	public void c_test() throws Exception {
		driver.manage().deleteAllCookies();
		
		// driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		assertTrue(driver.findElement(By.name("txtUsername")).isDisplayed());
	}
}
