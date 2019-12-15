package exercise.convert;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CommonsCSV {
	public enum Headers {
		id, name, a, b
	}
	
	public static void main(String[] args) throws IOException {
		// Java Project get Root Path
		String rootPath = System.getProperty("user.dir");
		Reader in = new FileReader(rootPath + "/src/data/csv/disease2.csv");
//		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("id", "name", "test1", "test2").parse(in);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		System.out.println("[ CSV Data Reader Start ]");
		for (CSVRecord record : records) {
			String id = record.get("id");
			String name = record.get("name");
			String symptom = record.get("a");
			String diagnosis = record.get("b");
//			System.out.println(record.get(Headers.a));
			System.out.println("[ id : " + id + " || name : " + name + " || symptom : " + symptom + " || diagnosis : " + diagnosis + "]");
		}
		System.out.println("[ CSV Data Reader End ]");
	}
}
