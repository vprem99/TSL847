package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.HelperFunctions;

public class Task3 {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("https://www.shoppersstop.com/store-finder");
		//driver.findElement(By.linkText("All Stores")).click();
		driver.findElement(By.name("cityName"));
		Select city = new Select(driver.findElement(By.name("cityName")));
		city.selectByVisibleText("Mumbai");

		Select pos = new Select(driver.findElement(By.name("pointOfServices")));
		List<WebElement> ls = pos.getOptions();
		for (WebElement E : ls) {
			System.out.println(E.getText());
		}
		cityCheck("Chennai", city.getOptions());
		cityCheck("Agra", city.getOptions());
		cityCheck("Latur", city.getOptions());
		cityCheck("aaaaa", city.getOptions());
	}
	public static void cityCheck(String city, List<WebElement> ls2) {
		boolean flag = false;
		for (WebElement E : ls2) {
			if (E.getText().equals(city)) {
				flag = true;
			}
		}
		if (flag == true)
			System.out.println(city + " Present");
		else
			System.out.println(city + " not Present");
	}
}