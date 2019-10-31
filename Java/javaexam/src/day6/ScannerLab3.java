package day6;

import java.util.Scanner;

public class ScannerLab3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// 입력된 숫자가 둘 중에 하나라도 0이하면
		// 첫 번째 숫자부터 다시 입력받게 한다.
		// "양의 값만 입력하세요!!"라는 메시지를 출력하고....
		// 첫 번째 숫자부터 다시 입력받게 한다.
		boolean check = true;
		int result = 0;
		int firstNum = 0;
		int secondNum = 0;
		String operator = "";
		while (check) {
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			firstNum = scn.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			secondNum = scn.nextInt();
			if (firstNum <= 0 || secondNum <= 0) {
				continue;
			}
		}
		System.out.print("연산자(+, -, *, /)를 입력하세요 : ");
		operator = scn.next();
		switch (operator) {
		case "+":
			result = firstNum + secondNum;
			break;
		case "-":
			result = firstNum - secondNum;
			break;
		case "/":
			result = firstNum / secondNum;
			break;
		case "*":
			result = firstNum * secondNum;
			break;
		}
		System.out.printf("%d 와 %d 의 %s 연산 결과는 %d 입니다.", firstNum, secondNum, operator, result);
		scn.close();
	}
}
