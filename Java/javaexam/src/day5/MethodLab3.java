package day5;

public class MethodLab3 {
	public static void main(String[] args) {
		final int REPEAT = 5;
		int num1 = 10, num2 = 20;
		int rn1, rn2;
		for(int i=0; i<REPEAT; i++) {
			rn1 = getRandom(num1);
			if(i == REPEAT-1) {
				System.out.println(rn1);
			} else {				
				System.out.printf("%d, ", rn1);
			}
		}
		for(int i=0; i<REPEAT; i++) {
			rn2 = getRandom(num1, num2);
			if(i == REPEAT-1) {
				System.out.println(rn2);
			} else {
				System.out.printf("%d, ", rn2);
			}
		}
		
	}
	public static int getRandom(int n) {
		int rn = (int)(Math.random() * (n - 1 + 1)) + 1;
		return rn;
	}
	public static int getRandom(int n1, int n2) {
		int rn = (int)(Math.random() * (n2 - n1 + 1)) + n1;
		return rn;
	}
}
