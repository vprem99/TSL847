package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgetPage {
	WebDriver driver;

	public ForgetPage(WebDriver driver) {
		// Initializing this class with driver
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	WebElement securityAuthentication_userName;
	WebElement btnSearchValues;
	WebElement btnCancel;

	public void doReset(String id) {
		securityAuthentication_userName.sendKeys(id);
		btnSearchValues.click();
	}

	public void doCancel() {
		btnCancel.click();
	}
}
