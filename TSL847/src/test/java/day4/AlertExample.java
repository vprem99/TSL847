package day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class AlertExample {

	public static void main(String[] args) throws Exception{
		WebDriver driver=HelperFunctions.setBrowser("firefox");
		driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");

		driver.findElement(By.xpath("//button[contains(text(),'Enter Name')]")).click();
		
		Alert al=driver.switchTo().alert();  // Focusing on Alert
		
		System.out.println(al.getText());  // getting text from Alert
		
		al.sendKeys("PREM");     // For Typing
		Thread.sleep(1000);
		//al.accept();  // For Pressing on OK button
		al.dismiss();  // Fore Pressing on Cancel Button
		/*In FronAccounting do login & Click on Sales Quotation Entry & press on Cancel Quotation
		You will get Alert & press on Cancel button of Alert*/ 
		
	}
}