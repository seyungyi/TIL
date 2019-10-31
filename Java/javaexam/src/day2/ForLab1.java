package day2;

public class ForLab1 {
	public static void main(String[] args) {

		int evenSum = 0;
		int oddSum = 0;
		for (int num = 1; num <= 100; num++) {
			int rawNum = num % 2;
			if (rawNum == 1) {
				oddSum += num;
			} else {
				evenSum += num;
			}
		}
		System.out.println("1 부터 100 까지의 숫자들 중에서" + "\n" + "짝수의 합은 " + 
		evenSum + "이고" + "\n" + "홀수의 합은 " + oddSum + "이다.");
	}

//		int evenSum = 0;
//		for (int evenNum = 0; evenNum <= 100; evenNum += 2) {
//			evenSum += evenNum;
//			System.out.println("합계 : " + evenSum);
//		}
}
