package day3;

public class WhileLab2 {
	public static void main(String[] args) {
		int count = 0;
		int numRan;
		char alp = '@';
		while (true) {
			numRan = (int) (Math.random() * 30) + 1; // (0~30)
			if ((numRan == 0) || (numRan >= 27 && numRan <= 30))
				break;

			System.out.printf("%c (%d)\n", numRan + 64, numRan);
			System.out.printf("%c (%d)\n", 'A' + (numRan - 1), numRan);
			System.out.printf("%c (%d)\n", alp + numRan, numRan);
			count++; // count = count + 1; count += 1;
		}
		System.out.printf("수행횟수는 %d번입니다", count);
	}
}