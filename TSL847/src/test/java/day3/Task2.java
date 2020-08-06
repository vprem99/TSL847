package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("http://rediff.com");
		
		driver.switchTo().frame("moneyiframe");
	
		System.out.println(driver.findElement(By.id("bseindex")).getText());
		System.out.println(driver.findElement(By.id("nseindex")).getText());
	}
}
