package day10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class ReflectionClassExample {
	@Test
	public void f() throws Exception {

		Class cl = Class.forName("org.openqa.selenium.chrome.ChromeDriver");

		Method mt[] = cl.getDeclaredMethods(); // Only Child Specific Functions will be given
		for (Method m : mt) {
			System.out.println(m.getName());
		}
		System.out.println("<------------------>");
		System.out.println(cl.getSuperclass());

		Method mt2[] = cl.getMethods(); // Functions from Super Class
		for (Method m : mt2) {
			System.out.println(m.getName());
		}

		Field[] fd = cl.getFields();
		for (Field f : fd) {
			System.out.println(f.getName());
		}

	}
}
