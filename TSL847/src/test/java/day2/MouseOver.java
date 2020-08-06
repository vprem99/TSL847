package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.HelperFunctions;

public class MouseOver {

	public static void main(String[] args) {
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.manage().window().maximize();  // Why : For Maximizing Browser
		
		driver.get("http://ugc.ac.in");

		WebElement publications=driver.findElement(By.linkText("Publications"));	
		Actions ac=new Actions(driver);
		ac.moveToElement(publications).perform();
		
		WebElement report=driver.findElement(By.linkText("Annual Reports/ Annual Accounts"));
		ac.click(report).perform();
		
		if(driver.getTitle().contains("Annual Reports"))
			System.out.println("Test for Annual Report is Passed");
		else
			System.out.println("Test for Annual Report is Failed");
		
		
	}
}