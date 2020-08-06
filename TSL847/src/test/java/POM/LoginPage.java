package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePOM{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	By e_username = By.name("txtUsername");
	By e_password = By.name("txtPassword");
	By e_login = By.id("btnLogin");
	By e_forget = By.linkText("Forgot your password?");
	public WelcomePage doLogin(String un, String pwd) {
		driver.findElement(e_username).sendKeys(un);
		driver.findElement(e_password).sendKeys(pwd);
		driver.findElement(e_login).click();
		return new WelcomePage(driver);
	}
	public ForgetPage goToForgetPage() {
		driver.findElement(e_forget).click();
		return new ForgetPage(driver);
	}

}
