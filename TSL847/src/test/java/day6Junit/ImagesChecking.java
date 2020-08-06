package day6Junit;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

import utils.HelperFunctions;

public class ImagesChecking {
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
	public void test() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> ls = driver.findElements(By.xpath("//a"));
		System.out.println("Total Images are " + ls.size());

		for (int i = 0; i < ls.size(); i++) {
			String src = ls.get(i).getAttribute("href");
			System.out.println(src);
			URL url = new URL(src); // Converting string in url format
			URLConnection con = url.openConnection(); // Opens a port/channel for connection with Remote server
			
			HttpsURLConnection httpCon=(HttpsURLConnection)con;
			
			httpCon.connect();   // It will connect with Actual Network.
			System.out.println(httpCon.getResponseCode());
			if(httpCon.getResponseCode()==200)
				System.out.println("Passed");
			else
				System.out.println("Not Passed");
			//assertEquals(200, httpCon.getResponseCode());
		}
	}
}