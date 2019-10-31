package day2;

public class BreakTest1 {
	public static void main(String[] args) {
		for (int dan = 1; dan < 10; dan++) {
			for (int num = 1; num <= 9; num++) {
				if (dan * num > 30)
					break;
				System.out.print(dan + "x" + num + "=" + dan * num + "\t");
			}
			System.out.println();
		}
	}
}
