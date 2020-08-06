package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.HelperFunctions;

public class KeyboardControl {

	public static void main(String[] args) {
		WebDriver driver=HelperFunctions.setBrowser("chrome");
		driver.get("http://google.com");
		Actions ac=new Actions(driver);
		
		WebElement search=driver.findElement(By.name("q"));
		
	Action a=	ac.keyDown(Keys.SHIFT)
		  .sendKeys(search,"lti")
		  .keyUp(Keys.SHIFT)
		  .doubleClick(search)
		  .contextClick(search)   //right Click
		  .build();		
	
	a.perform();  // To do() perform the mentioned steps
		
	/*	Difference Between Actions & Action
		1.Actions:
				It is Class
				Used in Situation when there is need of handling Keyboard 
				or Mouse
				
		2.Action
				>It is Interface
				>WhenEver there is need of composite(collection of Steps) Actions
				then you can store & later it can be used by perform method*/
	}
}