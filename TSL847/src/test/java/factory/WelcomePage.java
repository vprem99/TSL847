package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	public WelcomePage(WebDriver driver) {
		// Initializing this class with driver
		PageFactory.initElements(driver, this);
	}
}
