package day5;

public class MethodLab2 {
	public static void main(String[] args) {
		final int REPEAT = 5;
		int num1, num2;
		for(int i=0; i<REPEAT; i++) {
			num1 = (int)(Math.random() * 30) + 1;
			num2 = (int)(Math.random() * 30) + 1;
			System.out.printf("%d 와 %d 의 차는 %d 입니다.", num1, num2, RandomCompare(num1, num2));
			System.out.println();
		}
	}
	static int RandomCompare(int first, int second) {
//		int result;
//		if(first > second) {
//			result = first - second;
//		} else {
//			result = second - first;
//		}
		int result;
		if(first == second) {
			result = 0;
		} else {
			result = Math.abs(first - second);
		}
		return result;
	}
}
