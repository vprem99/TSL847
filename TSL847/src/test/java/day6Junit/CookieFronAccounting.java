package day6Junit;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class CookieFronAccounting {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = HelperFunctions.setBrowser("chrome");
		System.out.println(driver + " In Setup");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void b_test() throws Exception {
		driver.get("http://demo.frontaccounting.eu/");
		Set<Cookie> allCookie = driver.manage().getCookies();
		for (Cookie C : allCookie) {
			System.out.println("Name of Cookie is " + C.getName());
			System.out.println("value of Cookie is " + C.getValue());
			System.out.println("Expiry of Cookie is " + C.getExpiry());
			System.out.println("Domain of Cookie is " + C.getDomain());
			System.out.println("Path of Cookie is " + C.getPath());
		}
		driver.findElement(By.name("user_name_entry_field")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("user_name_entry_field")).sendKeys("demouser");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("SubmitUser")).click();	
		Thread.sleep(7000);
		Set<Cookie> allCookie2 = driver.manage().getCookies();
		for (Cookie C : allCookie2) {
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
		assertTrue(driver.findElement(By.name("user_name_entry_field")).isDisplayed());
	}
}