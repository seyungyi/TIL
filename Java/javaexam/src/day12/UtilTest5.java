package day12;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class UtilTest5 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("c:\\binarydata.txt"));
		Scanner sc = new Scanner(System.in);		
		int number = sc.nextInt();
		sc.nextLine();
		String inputLines[] = new String[number];
		for(int i=0; i < inputLines.length; i++) {
			inputLines[i] = sc.nextLine();			
		}
		System.out.println("읽어들인 데이터 :");
		for(int i=0; i < inputLines.length; i++)
			System.out.printf("%s ", inputLines[i]);
		System.out.println();
		int decimal = 0;
		for(int i=0; i < inputLines.length; i++) {			
			decimal = Integer.parseInt(inputLines[i], 2);
			System.out.printf("%s : %d%n", inputLines[i], decimal);			
		}
		sc.close();
	}
}










