package day6;

import java.util.Scanner;

public class ScannerLab1_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		String firstNum = scn.nextLine();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		String secondNum = scn.nextLine();
		System.out.print("연산자를 입력하세요 : ");
		String operator = scn.nextLine();
		int num1 = Integer.parseInt(firstNum);
		int num2 = Integer.parseInt(secondNum);
		scn.close();
		int result=0;
		switch(operator) {
		case "+" :
			result = num1 + num2;
			break;
		case "-" :
			result = num1 - num2;
			break;
		case "/" :
			result = num1 / num2;
			break;
		case "*" :
			result = num1 * num2;
			break;
		default :
			break;
		}
		System.out.printf("%d 와 %d 의 %s 연산 결과는 %d 입니다.", 
				num1, num2, operator, result);
	}
}
