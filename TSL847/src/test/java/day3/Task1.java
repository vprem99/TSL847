package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.HelperFunctions;

public class Task1 {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("http://ugc.ac.in");
		String PID = driver.getWindowHandle(); // ID of Current focused tab
		System.out.println("Parent Window ID is " + PID);
		Actions ac = new Actions(driver);
		WebElement U = driver.findElement(By.linkText("Universities"));
		ac.moveToElement(U).perform();

		WebElement CU = driver.findElement(By.partialLinkText("Central"));
		ac.moveToElement(CU).perform();
		System.out.println(CU.getAttribute("href"));
		// driver.get(CU.getAttribute("href"));
		CU.click();

		Set<String> allWin = driver.getWindowHandles();
		System.out.println("ID of EveryTab as Below");
		for (String id : allWin) {
			System.out.println(id);
			if (!(id.equals(PID))) {
				// Used to focus on window on which we Are interested
				driver.switchTo().window(id);  
				System.out.println("Title is " + driver.getTitle());
				driver.close();  // CLosing particular tab/Window
			}
		}
	}
}