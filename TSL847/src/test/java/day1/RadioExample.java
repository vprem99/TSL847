package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperFunctions;

public class RadioExample {

	public static void main(String[] args) throws Exception {
		WebDriver driver = HelperFunctions.setBrowser("CHROME");
		driver.get("https://facebook.com/");

		// driver.findElement(By.cssSelector("input[value='2']")).click();

		List<WebElement> ls = driver.findElements(By.name("sex"));
		ls.get(2).click();

		for (int i = 0; i < ls.size(); i++) {
			Thread.sleep(2000);
			ls.get(i).click();
		}

		WebElement custom = driver.findElement(By.cssSelector("input[value='-1']"));

		boolean x = custom.isSelected();
		System.out.println("Radio selection is " + x);

		boolean y = custom.isDisplayed(); // Displaying on Screen or not ?
		boolean z = custom.isEnabled();   // Object is Enabled for doing some operations or not
		
		if(x==true && y==true && z==true)
			System.out.println("Test for Custom Radio is Passed");
		else
			System.out.println("Test for Custom Radio is Failed");

	}
}