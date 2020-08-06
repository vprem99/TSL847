package day6Junit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperFunctions;

public class Task1 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = HelperFunctions.setBrowser("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("SPORTS")).click();
		assertEquals("Get Ahead headlines", driver.findElement(By.linkText("GET AHEAD")).getAttribute("title"));

		List<WebElement> ls = driver
				.findElements(By.xpath
						("//div[@class='secstorybox sports topboxheight relative']//h2[*]/a"));
		System.out.println(ls.size());
		for (int i = 1; i < ls.size(); i++) {
			System.out.println(ls.get(i).getAttribute("title"));
		}
	}
}
