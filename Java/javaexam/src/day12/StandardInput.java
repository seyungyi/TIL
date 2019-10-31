package day12;

import java.io.InputStreamReader;

public class StandardInput {
	public static void main(String[] args) throws Exception {
		System.out.print("입력 : ");
		// char input = (char)System.in.read(); // InputStream객체 참조
		char input = (char)new InputStreamReader(System.in).read();
		System.out.println("입력된 내용 : " + input);
	}
}
