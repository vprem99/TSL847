package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SwappingValuesWithoutThirdVariable {

	public static void main(String[] args) {
		int a, b, c;
		a = 20;
		b = 30;
		System.out.println("Values of A & B Before Swap");
		System.out.println(a + " " + b);
		/*
		 * a=a*b; //600 b=a/b; // b=600/30=20 a=a/b; // a=600/20=30
		 */
		a = a + b; // 50
		b = a - b; // 50-30 : 20
		a = a - b; // 50-20 : 30

		System.out.println("Values of A & B After Swap");
		System.out.println(a + " " + b);

		try {
			System.out.println("Values of A & B After Swap");
			FileInputStream ip=new FileInputStream("");
		} catch (FileNotFoundException N) {
			System.out.println("Values of A & B After Swap");
		} catch (Exception E) {
			System.out.println("Values of A & B After Swap");
		}
	}
}