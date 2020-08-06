package day10;

import org.testng.annotations.Test;

public class GroupingExamples {

	@Test(groups = { "smoke" })
	public void f1() {
		System.out.println("Smoke Test");
	}

	@Test(groups = { "smoke", "regression" })
	public void f2() {
		System.out.println("Smoke Test & Regression Test");
	}

	@Test(groups = { "regression" })
	public void f3() {
		System.out.println("Regression Test");
	}

	@Test(groups = { "sanity" })
	public void f4() {
		System.out.println("Sanity Test & Regression");
	}
}
