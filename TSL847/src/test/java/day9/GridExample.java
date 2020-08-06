package day9;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExample {
	WebDriver driver;
	@Test
	public void f() throws Exception {
		driver.get("http://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) throws Exception {
		DesiredCapabilities dc = null;
		if (browser.equals("chrome")) {
			dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
		} else if (browser.equals("firefox")) {
			dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
		}
		dc.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://192.168.0.104:3761/wd/hub"), dc);
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}