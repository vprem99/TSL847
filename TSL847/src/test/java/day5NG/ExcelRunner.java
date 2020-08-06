package day5NG;

import utils.ExcelReader;

public class ExcelRunner {
	public static void main(String[] args) {
		ExcelReader ex = new ExcelReader("C:\\Users\\Bhajan\\Desktop\\SelJars\\data2.xls");
		System.out.println(ex.getCellData("Sheet2", 3, 0));

	}
}