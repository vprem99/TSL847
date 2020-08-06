package day6Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFirstJunit_Test {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("In Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("In After Class");
	}

	@Before
	public void setup() {
		System.out.println("In Before Method "); // Run for Every Test 
	}

	@After
	public void teardown() {
		System.out.println("In After Method");
	}

	@Test
	public void b() {
		System.out.println("In test2");
	}
	@Test
	public void a() {
		System.out.println("In test1");
	}
}
