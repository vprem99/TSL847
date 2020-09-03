package codility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@Test
	public void f1() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // Initialized
		driver.get("http://www.google.com");
	}
	
	@Test
	public void f2() {
		System.out.println(driver.getTitle());
	}
}