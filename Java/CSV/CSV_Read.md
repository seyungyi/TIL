# CSV Read Example

```java
package exercise.convert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvRead {
	public static void main(String[] args) {
		List<List<String>> records = new ArrayList<>();
		BufferedReader br = null;
		String path = "/home/ysgo/workspace/Development/eclipse-ubuntu/exercise/src/data/csv/";
		String fileName = "disease.csv";
		try {
			br = Files.newBufferedReader(Paths.get(path+fileName));
			String line = "";
			while((line = br.readLine()) != null) {
//				System.out.println(line);
				List<String> tmpList = new ArrayList<>();
				String[] values = line.split(",");
				tmpList = Arrays.asList(values);
				records.add(tmpList);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(records);
	}
}
```

