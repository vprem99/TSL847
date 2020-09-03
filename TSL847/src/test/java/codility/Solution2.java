package codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class Solution2 extends WebDriverTestCase {
	@Test
	public void test1() {
		//webDriver.get("http://bing.com");
		String currentTitle = webDriver.getTitle();
		assertEquals("Bing", currentTitle);
		assertTrue(currentTitle.equals("Bing"));
	}

	@Test
	public void test2() throws Exception{
		webDriver.findElement(By.name("q")).sendKeys("LTI");
		webDriver.findElement(By.xpath("//label[@class='search icon tooltip']")).click();
		Thread.sleep(3000);
		int sz=webDriver.findElements(By.xpath("//ol[@id='b_results']/li")).size();
		assertTrue(sz>=1);
	}
	
	@Test
	public void test3() throws Exception{
		webDriver.get("https://www.shoppersstop.com");
		webDriver.findElement(By.xpath("//div[@class='col-md-5 col-lg-5']//input[2]")).click();
		//webDriver.findElement(By.xpath("//label[@class='search icon tooltip']")).click();
		Thread.sleep(3000);
		boolean isDisplayed=webDriver.findElement(By.xpath("//h1[contains(text(),'No Results Found')]")).isDisplayed();
		assertTrue(isDisplayed);
	}
}