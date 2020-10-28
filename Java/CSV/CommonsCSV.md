# [ Commons CSV ]

## CSV

- 정의 : 쉼표로 구분된 값을 저장하는 텍스트 파일 형식으로 주로 엑셀 등에서 데이터를 텍스트 파일로 저장할 때 사용된다



## Commons CSV

- 아파치 재단에서 자바 프로그래머를 위한 CSV 라이브러리를 제공함

  > 참조 링크
  >
  > 1. http://commons.apache.org/proper/commons-csv/
  >
  > 2. http://commons.apache.org/proper/commons-csv/user-guide.html
  > 3. http://commons.apache.org/proper/commons-csv/apidocs/index.html

- `CSVParser` 클래스 : 생성자 또는 스태틱 메서드인 parse() 를 통해서 생성한다. 파서를 생성한 후 getRecords() 메서드를 사용하면 CSV 파일의 각 행을 나타하는 List 객체를 얻을 수 있다.

- `CSVFormat` 클래스 : 자주 사용되는 몇 가지 형식들이 사전 정의 되어 있으며, 입맛에 맞게 변경할 수 있다. parser() 메서드를 통해서 CSVParser를 얻을 수도 있다.

- `CSVRecord` 클래스 : CSV 파일의 각 행에 해당하는 정보를 담고 있다. get() 메서드를 통해서 셀의 데이터를 문자열 형식으로 얻을 수 있다.

- `CSVPrinter` 클래스 : CSV 형식으로 데이터를 출력할 때 사용된다.



## Example

### Parser의 생성

- Reader (또는 InputStream) 객체을 통해서 파서를 생성하는 방법

  ```java
  CSVParser parser = new CSVParser( new InputStreamReader(inputStream, "UTF-8"), CSVFormat.EXCEL );
  List<CSVRecord> records = parser.getRecords();
  ...
  parser.close();
  ```

- File 객체를 통해서 파서를 생성하는 방법

  ```java
  CSVParser parser = CSVParser.parse(file, Charset.forName("UTF-8"), CSVFormat.EXCEL.withHeader());
  List<CSVRecord> records = parser.getRecords();
  ...
  parser.close();
  ```
  
- Example

  ```java
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
  ```

## TIP

> withHeader() 메서드를 사용하면 CSV 파일의 첫 줄에 있는 헤더와 매핑된 데이터를 얻을 수 있다

