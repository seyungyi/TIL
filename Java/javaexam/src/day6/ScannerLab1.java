package day6;

import java.util.Scanner;

public class ScannerLab1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean check = true;
		int result=0;
		end : while(check) {
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			int firstNum = scn.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			int secondNum = scn.nextInt();
			System.out.print("연산자(+, -, *, /)를 입력하세요 : ");
			String operator = scn.next();
			switch(operator) {
			case "+" :
				result = firstNum + secondNum;
				break;
			case "-" :
				result = firstNum - secondNum;
				break;
			case "/" :
				result = firstNum / secondNum;
				break;
			case "*" :
				result = firstNum * secondNum;
				break;
			default :
				check = false;
			}
			if(check) {
				System.out.printf("%d 와 %d 의 %s 연산 결과는 %d 입니다.", 
						firstNum, secondNum, operator, result);
				break end;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				check = true;
			}
		}
		scn.close();
	}
}
