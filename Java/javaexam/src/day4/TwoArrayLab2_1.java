package day4;

public class TwoArrayLab2_1 {

	public static void main(String[] args) {
		int[][] arr = { { 10, 20, 30, 40, 50 },
				{ 5, 10, 15, 3 }, 
				{ 11, 22, 33, 44 }, 
				{ 9, 8, 7, 6, 5, 4, 3, 2, 1 } 
				};

		int i, j, sum;

		for (i = 0; i < arr.length; i++) {
			sum = 0;
			for (j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			System.out.printf("%d행의 합은 %d입니다. ", i + 1, sum);
		}

	}
}