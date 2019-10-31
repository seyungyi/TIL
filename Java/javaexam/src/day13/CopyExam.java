package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class CopyExam {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now(); // 자바8버전부터 추가됨. 생성자가 감춰져 있음(private형)
		int year = ld.getYear();		// new LocalDate()가 안됨
		int month = ld.getMonthValue(); // 월 추출때 1부터 시작
		int day = ld.getDayOfMonth(); // of메소드라는 것이 존재
		String path = "C:/iotest/sample_" + year + "_" + month + "_" + day + ".txt";
		
		try(FileReader reader = new FileReader("C:\\iotest\\sample.txt"); // 한단어씩 읽을수 있음
				BufferedReader br = new BufferedReader(reader); // 행단위 읽을때 사용
				FileWriter fw = new FileWriter(path, true)) {
			String data;
			while(true) {
				data = br.readLine();
				if(data == null)
					break;
				fw.write(data + "\r\n"); // printf에서만 %n을 지원
			}
			System.out.println("저장 완료되었습니다.");
		} catch(Exception e) { // FileNotFoundException은 IOException의 자식이기에 후자로 사용 가능
			System.out.println("처리하는 동안 오류가 발생했습니다.");
		}
	}
}
