package day2;

public class ForLab3 {
	public static void main(String[] args) {
		int num1 = (int) (Math.random() * 6) + 5; // 5~10
		final char A = '&';
		for (int i = 0; i <= num1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(A);
			}
			System.out.println();
		}
	}
}
