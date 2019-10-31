package day2;

public class ForTest4 {
	public static void main(String[] args) {
		for (int dan = 1; dan < 10; dan++) {
			for (int num = 1; num <= 9; num++) {
				//System.out.printf("%d", dan + "x" +"%d", num + "=" +"%d", dan * num + "\t");
				System.out.printf("%d x %d = %d\t", dan, num, dan*num);
			}
			System.out.println();
		}
	}
}
