package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.HelperFunctions;

public class MangneticAutomation {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("http://www.magneticautomation.in/p/drop-down-example.html");
		Select s = new Select(driver.findElement(By.name("multi")));

		s.selectByVisibleText("One");
		s.selectByVisibleText("Three");
		System.out.println("Multi Select option status " + s.isMultiple());

		// Getting options which are selected in drop Down
		List<WebElement> option = s.getAllSelectedOptions();
		System.out.println("Total Options Selected " + option.size());
		// printing Selected Options
		for (int i = 0; i < option.size(); i++) {
			System.out.println(option.get(i).getText());
		}
		// For Printing all options of drop Down
		List<WebElement> allOptions = s.getOptions();
		System.out.println("------All options as Below------");
		for (WebElement E : allOptions) {
			System.out.println(E.getText());
		}
		
		s.deselectByVisibleText("One");  // This works only with multi select drop down
		
		s.deselectAll();  // This works only with multi select drop down
		
		driver.close(); // Cl
	}
}