package day5;

public class MethodTest8 {
	public static void main(String[] args) {
		/*
		int i=0;
		while(i<5) {
			int num1 = (int)(Math.random()*30) + 1;
			int num2 = (int)(Math.random()*30) + 1;
			System.out.println(num1 + "과 " + num2 + "중 더 큰 수는 " + 
					getBigNumber(num1, num2) + " 이다.");
			System.out.println(" = " + isEven(getBigNumber(num1, num2)) + " 이다.");
			i++;
		} */
		int arg1 = MethodLab3.getRandom(1, 10);
		int arg2 = MethodLab3.getRandom(1, 10);
		int bigNumber = getBigNumber(arg1, arg2);
		System.out.println("수행 결과 값 : " + bigNumber);
		if(isEven(bigNumber) == true) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
	}
	static int getBigNumber(int num1, int num2) {
		int bigNumber;
		if(num1 > num2) {
			bigNumber = num1;
		} else {
			bigNumber = num2;
		}
		return bigNumber;
	}
	static boolean isEven(int number) {
		boolean result = false;
		if(number % 2 == 0) {
			//System.out.print("짝수");
			result = true;
		} else {
			//System.out.print("홀수");
		}
		return result; 
	}
}
