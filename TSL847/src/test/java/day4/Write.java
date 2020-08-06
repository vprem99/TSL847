package day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {

	public static void main(String[] args) throws Exception{
		// Taking input as file
		FileInputStream inputFile = new FileInputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data.xlsx");
		// Specifying its a workbook
		XSSFWorkbook wb = new XSSFWorkbook(inputFile);
		// Read Sheet Now
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		sh.getRow(2).getCell(1).setCellValue("LTI123");
		sh.createRow(3).createCell(2).setCellValue("LTI123");
		sh.createRow(5).createCell(2).setCellValue("LTI123");
		sh.createRow(0).createCell(2).setCellValue("LTI123");
		wb.write(new FileOutputStream("C:\\Users\\Bhajan\\Desktop\\SelJars\\data2.xlsx"));
	}
}