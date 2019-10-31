package day2;

public class WhileTest3 {
	public static void main(String[] args) {
		System.out.println("main () �������");
		char munja = 'd';
		while (munja < 's') {
			// System.out.println(munja);
			// System.out.printf("%c\n", munja);
			System.out.printf("%c %d %x\n", munja, (int)munja, (int)munja);
			munja++;
		}
		System.out.println("main () ��������");
	}
}
