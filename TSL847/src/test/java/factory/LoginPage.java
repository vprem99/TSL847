package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// Initializing this class with driver
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(linkText = "Forgot your password?")  WebElement e_forget;

	WebElement txtUsername;
	WebElement txtPassword;
	WebElement btnLogin;
	public WelcomePage doLogin(String un, String pwd) {
		txtUsername.sendKeys(un);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return new WelcomePage(driver);
	}

	public ForgetPage goToForgetPage() {
		e_forget.click();
		return new ForgetPage(driver);
	}

}
