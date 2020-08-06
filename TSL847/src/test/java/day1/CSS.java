package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS {
	/*
	 * 1.CSS with ID: tagname#id
	 * 
	 * 2.CSS with name/type/value or any other Property:> tagname[attribute='value
	 * of Attributes']
	 * 
	 * 3.CSS with className:- tagname.className
	 */
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhajan\\Desktop\\SelJars\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Starts Chrome Browser
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.panelTrigger")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/index.php/auth/logout']")).click();
	}
}