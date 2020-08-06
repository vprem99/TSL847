package day5NG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.HelperFunctions;

public class Task1 {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("https://www.rediff.com/");
		driver.switchTo().frame("moneyiframe");
		driver.findElement(By.id("query")).sendKeys("YES BANK LTD");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/form/input[2]")).click();
		Actions ac=new Actions(driver);
		//ac.sendKeys(driver.findElement(By.id("query")), Keys.ENTER).perform();;
		
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Assert.assertTrue(driver.getTitle().contains("YES BANK LTD"));
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		System.out.println(driver.getTitle());
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
