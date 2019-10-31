package day3;

public class ForLab4 {
	public static void main(String[] args) {
		final char star = '*';
		for (int i = 7; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(star);
			}
			System.out.println();
		}

	}
}
