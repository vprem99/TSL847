package day7;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Base;

public class PropertyFileExample extends Base {
	@Test(enabled=true,description="Printing Suggestions of Google")
	public void propertyTest() throws Exception {	
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name(prop.getProperty("searchField_name")))
										.sendKeys(prop.getProperty("searchKey"));
		//Thread.sleep(5000);
		List<WebElement> ls = driver.findElements(By.xpath("//ul[@class='erkvQe']/li[*]/div/div[2]/div[1]/span"));

		System.out.println(ls.size());

		for (int i = 0; i < ls.size(); i++) {
			ls = driver.findElements(By.xpath("//ul[@class='erkvQe']/li[*]/div/div[2]/div[1]/span"));
			System.out.println(ls.get(i).getText());
		}
	}
	
	@Test(enabled=false,description="Printing Suggestions of Bing")
	public void bingSuggestions() throws Exception {
		driver.get("http://bing.com");
		driver.findElement(By.name("q")).sendKeys("LTI");
		Thread.sleep(10000);
		List<WebElement> ls = driver.findElements(By.xpath("//ul[@id='sa_ul']/li[*]/div/span"));

		System.out.println(ls.size());

		for (int i = 0; i < ls.size(); i++) {
			//ls = driver.findElements(By.xpath("//ul[@id='sa_ul']/li[*]/div/span"));
			System.out.println(ls.get(i).getText());
		}
	}
}