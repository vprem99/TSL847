package day8;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.*;

import utils.Base;

public class POM_Runner extends Base {
	ForgetPage fp;
	LoginPage lp;
	@Test(priority = 1)
	public void loginPageTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 2, dependsOnMethods = "loginPageTest")
	public void forgetPageTest() {
		lp = new LoginPage(driver);
		fp = lp.goToForgetPage();
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCod");
	}

	@Test(priority = 3, dependsOnMethods = "forgetPageTest")
	public void forgetPageCancelTest() {
		fp.doCancel();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test(priority = 4, dependsOnMethods = "loginPageTest")
	public void loginTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WelcomePage wp=lp.doLogin("admin", "admin123");
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
}