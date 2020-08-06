package day6Junit;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.HelperFunctions;

public class SuggestionsHandling {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = HelperFunctions.setBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() {
		WebDriverWait wt=new WebDriverWait(driver, 30);
		
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).sendKeys("Ahmedabad");
		
	/*	WebElement E=wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
				("//ul[@id='ui-id-1']/li/a[contains(text(),'XHVJKHMBKJBJ')]")));
		E.click();*/
		
		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/a[contains(text(),'Ahmedddabad')]")).click();
		//driver.findElement(By.id("ToTag")).sendKeys("Hyderabad, Pak");
		//driver.findElement(By.xpath("//ul[@id='ui-id-2']/li/a[contains(text(),'Hyderabad, Pak')]")).click();
	/*	Implicit Wait 						Explicit Wait
		1.Global Wait						1.For Particular Object | Condition
		2.Only for Visibility of Object			2.Can wait for Alert, Frame, NumberofTabs
											url, particular title, invisibilityalso
		3.Need to declare only once			3.Multiple time Explicit functions need 						
											to be called
		4.Must have implicit wait			4.Depends upon Project need.*/
	
		
		
		
	}
}
