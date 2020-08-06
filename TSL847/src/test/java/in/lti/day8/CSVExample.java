package in.lti.day8;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class CSVExample {
	@Test
	public void f() throws Exception {
		CSVReader cs = new CSVReader(new FileReader(".\\src\\test\\resources\\files\\data.csv"));
		List<String[]> allData = cs.readAll(); // Read EveryThing in Single Attempt

		for (int i = 1; i < allData.size(); i++) {
			String rowData[] = allData.get(i);
			for (int j = 0; j < rowData.length; j++) {
				System.out.print(rowData[j] + "\t");
			}
			System.out.println();
		}

		String row[] = cs.readNext(); // if you interested in reading line by line (row by row)
	}
}
