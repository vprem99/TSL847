package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.HelperFunctions;

public class dropDwonExample {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");

		driver.get("http://facebook.com");
		
		WebElement mth=driver.findElement(By.name("birthday_month")); // Searching that Element
		Select month=new Select(mth);
		//month.selectByVisibleText("Dec");
		//month.selectByIndex(11);
		month.selectByValue("2");
		
		System.out.println("MultiSelect drop down status "+month.isMultiple());	
	}
}
