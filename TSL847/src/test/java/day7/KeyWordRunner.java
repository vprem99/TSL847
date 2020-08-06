package day7;

import org.testng.annotations.Test;

import utils.Base;
import utils.KeyWords;

public class KeyWordRunner extends Base {
	@Test
	public void f() {
		KeyWords key = new KeyWords(driver);
		key.getURL("http://selenium.dev");
		key.click("link:=Downloads");
		key.type("id:=gsc-i-id1", "SUCCESS");

		key.getURL("http://facebook.com");
		key.selectFromDropDown("name:=birthday_month", "Dec");
		key.getSnap("C:\\Users\\Bhajan\\Desktop\\SelJars\\facebook.png");
		key.closeBrowser();
	}
}