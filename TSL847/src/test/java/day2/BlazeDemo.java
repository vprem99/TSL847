package day2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.HelperFunctions;

public class BlazeDemo {
	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");

		driver.get("http://blazedemo.com");

		WebElement E1 = driver.findElement(By.name("fromPort"));
		Select from = new Select(E1);
		from.selectByVisibleText("Boston");

		Select to = new Select(driver.findElement(By.name("toPort")));
		to.selectByVisibleText("Rome");

		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		
		List<WebElement> flights=driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
		
		System.out.println("Total available flights "+flights.size());
		
		flights.get(1).click();

	}
}