package day2;

public class ForTest2 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
			System.out.println();
		}
		for (int i = 1; i <= 10; i += 2) {
			System.out.print(i + " ");
			System.out.println();
		}
		for (int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
			System.out.println();
		}
		// 10 20 30 40 50
		for (int i = 10; i <= 50; i += 10) {
			System.out.println(i + " ");
		}

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println("합계 : " + sum);
		}

		int pow = 1;
		for (int i = 1; i <= 10; i++) {
			pow = pow * i;
			System.out.print("10 팩토리얼 : " + pow);
			System.out.println();
		}
	}
}
