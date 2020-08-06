package day3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import utils.HelperFunctions;

public class DragNDrop {

	public static void main(String[] args) throws Exception{
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement des = driver.findElement(By.id("droppable"));
		Actions ac=new Actions(driver);		
		ac.dragAndDrop(src, des).perform();
/*		ChromeDriver d=new ChromeDriver();
		//d.getScreenshotAs(arg0)
		
		WebDriver driver2=new ChromeDriver();
		//parent p=new Child();
*/		
	/*	ChromeDriver is Child of 
		WebDriver, TakesScreenShot(>getScreenshotAs) & JavaScriptExecutor(All three are interface)*/
		TakesScreenshot tc=(TakesScreenshot)driver;
		// It will take ScreenShot & store in Java Buffer memory
		File scFile=tc.getScreenshotAs(OutputType.FILE);  
		FileHandler.copy(scFile, new File(".\\dragNdrop2.png"));

	}
}