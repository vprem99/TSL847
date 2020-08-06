package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage extends BasePOM {

	public ForgetPage(WebDriver driver) {
		super(driver);
	}

	By e_user = By.id("securityAuthentication_userName");
	By e_reset = By.id("btnSearchValues");
	By e_cancel = By.id("btnCancel");

	public void doReset(String id) {
		driver.findElement(e_user).sendKeys(id);
		driver.findElement(e_reset).click();
	}

	public void doCancel() {
		driver.findElement(e_cancel).click();
	}
}
