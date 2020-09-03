package codility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.HelperFunctions;

public class WebDriverTestCase {
	public static WebDriver webDriver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/*System.setProperty(key, value);
		webDriver=new ChromeDriver();*/
		webDriver=HelperFunctions.setBrowser("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}