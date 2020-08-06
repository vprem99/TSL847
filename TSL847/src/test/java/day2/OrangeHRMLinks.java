package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperFunctions;

public class OrangeHRMLinks {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");

		// to opening url
		driver.get("https://opensource-demo.orangehrmlive.com/");

		List<WebElement> ls = driver.findElements(By.tagName("a"));
		int sz = ls.size();
		System.out.println("Total available links are " + sz);

		// driver.findElements(By.tagName("img"));

		// To find Name of Every WebElements
		for (int i = 0; i < sz; i++) {
			System.out.println("Link "+i);
			System.out.println(ls.get(i).getText());
			System.out.println(ls.get(i).getAttribute("href"));
		}
	}
}