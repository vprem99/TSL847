package codility;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class cpsat_sol extends WebDriverTestCase {

	@Test
	public void test() throws InterruptedException {
		webDriver.get("https://www.imdb.com/");
		webDriver.findElement(By.id("suggestion-search")).sendKeys("Gangs of New York");
		webDriver.findElement(By.id("suggestion-search-button")).click();

		webDriver.findElement(By.xpath("//div//div//div//div[2]//table[1]//tbody[1]//tr[1]//td[2]//a[1]")).click();
		Thread.sleep(5000);
		String time = webDriver.findElement(By.xpath("(//time)[2]")).getText().split(" ")[0];
		assertTrue(Integer.parseInt(time) < 180);
		assertTrue(webDriver.findElement(By.xpath("//div[@id='titleStoryLine']//div[4]")).getText().contains("Crime"));
		assertTrue(webDriver.findElement(By.xpath("//span[contains(text(),'Rated R for intense strong violence, sexuality/nud')]")).getText().contains("R"));
	}
}