package day7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Base;
import utils.ExcelReader;
import utils.KeyWords;

public class ExcelKeyRunner extends Base {
	@Test(dataProvider = "dp")
	public void f(String exKey, String locator, String data) {
		// System.out.println(exKey+" "+locator+" "+data);
		KeyWords key = new KeyWords(driver);
		switch (exKey) {
		case "getURL":
			key.getURL(data);
			break;
		case "click":
			key.click(locator);
			break;
		case "type":
			key.type(locator, data);
			break;
		case "selectFromDropDown":
			key.selectFromDropDown(locator, data);
			break;
		case "getSnap":
			key.getSnap(data);
			break;
		case "closeBrowser":
			key.closeBrowser();
			break;
		default:
			System.out.println("Invalid KeyWord");
		}
	}
	@DataProvider
	public Object[][] dp() {
		ExcelReader ex = new ExcelReader("C:\\Users\\Bhajan\\Desktop\\SelJars\\Book1.xlsx");
		int row = ex.getRowNum(prop.getProperty("sheetName"));
		int col = ex.getColumnNum(prop.getProperty("sheetName"));
		Object data[][] = new Object[row - 1][col];
		for (int i = 0; i < row - 1; i++) {
			data[i][0] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 0);
			data[i][1] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 1);
			data[i][2] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 2);
		}
		return data;
	}
}