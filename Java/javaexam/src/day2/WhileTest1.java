package day2;

public class WhileTest1 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		while (sum < 100) {
			i = (int)(Math.random()*50)+1; // 1 ~ 50
			sum += i;
			System.out.printf("sum = %d\n" + sum);
		}
	}
}
