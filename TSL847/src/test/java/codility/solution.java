package codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class solution extends WebDriverTestCase {

	/*@Test
	public void a() {
		String title = webDriver.getTitle();
		assertEquals("Bing", title); // Expected First & Then Actual
		assertTrue(title.equalsIgnoreCase("Bing"));
		assertEquals(true, title.equalsIgnoreCase("Bing")); // Expected First & Then Actual
	}

	@Test
	public void b() throws Exception{
		webDriver.findElement(By.name("q")).sendKeys("LTI");
		webDriver.findElement(By.xpath("//label[@class='search icon tooltip']")).click();
		Thread.sleep(3000);
		int sz=webDriver.findElements(By.xpath("//ol[@id='b_results']/li")).size();
		assertTrue(sz>=1);
	}*/
	
	@Test
	public void c() throws Exception{
		/*Open https://www.shoppersstop.com/
			  if Searching happens with blank field then No Results Found Message should display*/
		webDriver.get("https://www.shoppersstop.com");
		webDriver.findElement(By.xpath("//div[@class='col-md-5 col-lg-5']//input[2]")).click();
		//webDriver.findElement(By.xpath("//label[@class='search icon tooltip']")).click();
		Thread.sleep(3000);
		boolean isDisplayed=webDriver.findElement(By.xpath("//h1[contains(text(),'No Results Found')]")).isDisplayed();
		assertTrue(isDisplayed);
	}
}