package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.HelperFunctions;

public class Read {

	public static void main(String[] args) throws Exception {
		// Taking input as file
		FileInputStream inputFile = new FileInputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data.xlsx");
		// Specifying its a workbook
		XSSFWorkbook wb = new XSSFWorkbook(inputFile);
		// Read Sheet Now
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum() + " Rows ");
		System.out.println(sh.getRow(0).getLastCellNum() + " Columns");
		WebDriver driver = HelperFunctions.setBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			String un = sh.getRow(i).getCell(0).toString();
			System.out.print(un + "\t");
			String pwd = sh.getRow(i).getCell(1).toString();
			System.out.print(pwd);
			driver.findElement(By.xpath("//*[@name='txtUsername']")).clear();
			driver.findElement(By.xpath("//*[@name='txtUsername']")).sendKeys(un);
			driver.findElement(By.xpath("//*[@type='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
				System.out.println("\t Login Done");
				sh.getRow(i).createCell(2).setCellValue("PASS");
			} catch (Exception E) {
				System.out.println("\t Login Failed");
				sh.getRow(i).createCell(2).setCellValue("FAILED");

			}
		}
		
		wb.write(new FileOutputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data2.xlsx"));

	}
}
