package polynomial;

public class RotationMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}
		
		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));

		// rotateMatrix1 testCase
		printMatrix(arr);
		printMatrix(rotateMatrix1(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix1(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix1(arr2));
	}

	// ? •?‚¬ê°í˜• ë°°ì—´?„ ?‹œê³„ë°©?–¥?œ¼ë¡? ?•œì¹¸ì”© ?´?™
	// ?—¬ê¸°ë?? êµ¬í˜„?•˜?„¸?š” :)
	public static int[][] rotateMatrix(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		return result;
	}

	// ? •?‚¬ê°í˜• ë°°ì—´?˜ ???ˆ˜ë²ˆì§¸ ì¤„ì? ë°˜ì‹œê³„ë°©?–¥, ì§ìˆ˜ë²ˆì§¸ ì¤„ì? ?‹œê³„ë°©?–¥?œ¼ë¡? ?•œì¹¸ì”© ?´?™
	// ?—¬ê¸°ë?? êµ¬í˜„?•˜?„¸?š” :)
	public static int[][] rotateMatrix1(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		return result;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
