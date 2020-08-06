package day5NG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class All_Annotations {
	@Test
	public void f1() {
		System.out.println("In Test 1");
	}
	@Test
	public void f2() {
		System.out.println("In Test 2");
	}
	@Test
	public void f3() {
		System.out.println("In Test 3");
		Date date = new Date();
		System.out.println(date);
		String newDate=date.toString().replaceAll(" ","_").replaceAll(":", "_");
		System.out.println(newDate);
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("In before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("In after Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("In Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("In after Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("In Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("In After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("In Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("In after Suite");
	}
}
