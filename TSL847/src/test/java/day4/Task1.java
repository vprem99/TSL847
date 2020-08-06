package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.HelperFunctions;

public class Task1 {
	public static void main(String[] args) throws Exception {
		FileInputStream inputFile = new FileInputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data.xlsx");
		// Specifying its a workbook
		XSSFWorkbook wb = new XSSFWorkbook(inputFile);
		// Read Sheet Now
		XSSFSheet sh = wb.getSheet("Sheet2");

		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("https://jmeter.apache.org/");
		HelperFunctions.getSnap("jmeter.png");

		List<WebElement> ls = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/ul[4]/li[1]/ul[1]/li"));
		int sz = ls.size();
		System.out.println("Total Tutorials are " + sz);

		for (int i = 1; i <= sz; i++) {
			WebElement E=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/ul[4]/li[1]/ul[1]/li["+i+"]/a"));
			String txt=E.getText();
			String href=E.getAttribute("href");
			System.out.println(txt+"--------"+href);
			XSSFRow row=sh.createRow(i);
			row.createCell(0).setCellValue(txt);
			row.createCell(1).setCellValue(href);
		}
		wb.write(new FileOutputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data2.xlsx"));
	}
}