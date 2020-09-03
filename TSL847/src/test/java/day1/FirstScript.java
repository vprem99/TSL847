package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {
	public static void main(String[] args) {

		/*
		 * WebDriver is Interface & ChromeDriver, FirefoxDriver, OperaDriver are classes
		 * which implements WebDriver
		 * 
		 * WebDriver is Parent & ChromeDriver, FirefoxDriver & OperaDriver are Childs
		 */
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Bhajan\\Desktop\\SelJars\\drivers\\chromedriver.exe"); WebDriver
		 * driver = new ChromeDriver(); // Starts Chrome Browser
		 */
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Starts Chrome Browser

		// Parent p=new Child
		// Declaring variable as Parent type has benefit of Holding any Child Object

		driver.get("http://selenium.dev");

		String title = driver.getTitle(); // Captures current page title

		System.out.println("Current title of Page is " + title);

		// driver.findElement(By.linkText("Downloads")).click();

		WebElement d = driver.findElement(By.linkText("Downloadss"));
		d.click();

		System.out.println("You are on " + driver.getTitle() + " Page");
		// driver.quit(); // Closing Browser
		driver.navigate().back();
		//driver.quit();
	}
}