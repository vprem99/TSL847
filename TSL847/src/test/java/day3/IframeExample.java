package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class IframeExample {

	public static void main(String[] args) {
		WebDriver driver=HelperFunctions.setBrowser("chrome");
		driver.get("file:///C:/Users/Bhajan/Desktop/TSL-AT/iframe.html");

		driver.switchTo().frame("blaze");  // Using Id or name of iframe
		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
		
		driver.switchTo().defaultContent(); // to get out of Iframe
		driver.switchTo().frame(1);   // Switching iframe with index
		driver.findElement(By.id("sb_form_q")).sendKeys("LTI");
		
		driver.switchTo().defaultContent(); // to get out of Iframe

		// Switching iframe with WebElement as a Argument
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.dummy")));  
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/nav/div/div/div/div[1]/div[1]/div/ul/li[1]/a")).click();
		
	}
}
