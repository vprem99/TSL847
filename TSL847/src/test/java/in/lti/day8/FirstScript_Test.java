package in.lti.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Base;

public class FirstScript_Test extends Base {
	@Test(priority = 1, description = "Title test for Selenium Dev")
	public void titleTest() {
		driver.get("http://selenium.dev");
		Assert.assertEquals(driver.getTitle(), "SeleniumHQ Browser Automation");
	}

	@Test(priority = 2, dependsOnMethods="titleTest",description = "Scroll Example")
	public void Scrolling_Test() throws Exception{
		// ChromeDriver is Child of WebDriver, TakesScreenShot, JavascriptExecutor
		//TakesScreenshot sp=(TakesScreenshot)driver;
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//b[contains(text(),'MORE NEWS')]")) );	
		//1.Scroll to Directly to some Object
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300);");
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-300);");
		
		Thread.sleep(3000);
		// Scroll to Body Height 
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight);");

		Thread.sleep(3000);
		// Scroll to Body Height 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
	}
}
