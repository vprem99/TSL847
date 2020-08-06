package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperFunctions;

public class DummyExamples {

	public static void main(String[] args) {
	WebDriver driver=	HelperFunctions.setBrowser("chrome");
	
	driver.get("http://facebook.com");
	
	/*List<WebElement> ls=driver.findElements(By.name("prem"));
	
	System.out.println(ls.size());
*/	
	driver.findElement(By.name("sex")).click();
	}
}