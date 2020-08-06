package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class KeyWords {
	WebDriver driver;

	public KeyWords(WebDriver driver) {
		this.driver = driver;
	}

	public void getURL(String url) {
		driver.get(url);
	}

	public void click(String locator) {
		/*
		 * // locator ="name:=fromPort" String locatorType = locator.split(":=")[0];
		 * String locatorValue = locator.split(":=")[1]; if (locatorType.equals("id"))
		 * driver.findElement(By.id(locatorValue)).click(); else if
		 * (locatorType.equals("name"))
		 * driver.findElement(By.name(locatorValue)).click(); else if
		 * (locatorType.equals("link"))
		 * driver.findElement(By.linkText(locatorValue)).click(); else if
		 * (locatorType.equals("css"))
		 * driver.findElement(By.cssSelector(locatorValue)).click(); else if
		 * (locatorType.equals("xpath"))
		 * driver.findElement(By.cssSelector(locatorValue)).click(); else
		 * System.out.println("Invalid Locator");
		 */

		WebElement E = getElement(locator);
		E.click();
	}

	public void type(String locator, String data) {
		/*
		 * // locator ="name:=fromPort" String locatorType = locator.split(":=")[0];
		 * String locatorValue = locator.split(":=")[1]; if (locatorType.equals("id"))
		 * driver.findElement(By.id(locatorValue)).sendKeys(data); else if
		 * (locatorType.equals("name"))
		 * driver.findElement(By.name(locatorValue)).sendKeys(data); else if
		 * (locatorType.equals("link"))
		 * driver.findElement(By.linkText(locatorValue)).sendKeys(data); else if
		 * (locatorType.equals("css"))
		 * driver.findElement(By.cssSelector(locatorValue)).sendKeys(data); else if
		 * (locatorType.equals("xpath"))
		 * driver.findElement(By.cssSelector(locatorValue)).sendKeys(data); else
		 * System.out.println("Invalid Locator");
		 */
		WebElement E = getElement(locator);
		E.sendKeys(data);
	}

	public void selectFromDropDown(String locator, String option) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(option);
	}

	public WebElement getElement(String locator) {
		// locator ="name:=fromPort"
		String locatorType = locator.split(":=")[0];
		String locatorValue = locator.split(":=")[1];
		if (locatorType.equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if (locatorType.equals("link"))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.equals("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equals("xpath"))
			return driver.findElement(By.cssSelector(locatorValue));
		else
			return null;
	}

	public void getSnap(String fileNameWithLocation) {

		TakesScreenshot tc = (TakesScreenshot) driver;
		// It will take ScreenShot & store in Java Buffer memory
		File scFile = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scFile, new File(fileNameWithLocation));
		} catch (IOException e) {
			System.out.println("Error with ScreenShot");
		}
	}

	public void closeBrowser() {
		driver.quit();
	}
}
