package day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName & Password");
		String un = sc.next();
		String pwd = sc.next();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhajan\\Desktop\\SelJars\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Starts Chrome Browser
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys(un);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		try {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Welcome Admin")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Login Done");
		} catch (Exception E) {
			System.out.println("Login Failed");
		}
	}
}