package day4;

public class TwoArrayTest3 {
	public static void main(String[] args) {
		char[][] ary = new char[3][];
		ary[0] = new char[8];
		ary[1] = new char[4];
		ary[2] = new char[10];
		char lowerAlpha = 'a';
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[i].length; j++) {
				ary[i][j] = lowerAlpha++;
				System.out.printf("%c   ", ary[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[i].length; j++) {

				System.out.printf("%c   ", ary[i][j] - 32);
			}
			System.out.println();
		}
	}
}
