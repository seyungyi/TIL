package day1;

public class IfTest1 {
	public static void main(String[] args) {
		int num = (int)(Math.random()*10) + 1; // 1~10
		char result;
		if (num % 2 == 1)
			result = 'È¦';
		else
			result = 'Â¦';
		System.out.println(num + "Àº " + result + "¼öÀÔ´Ï´Ù.");
	}
}
