package day1;

public class OperTest3 {
	public static void main(String[] args) {
		int num = (int)(Math.random()*10) + 1; // 1~10
		char result = num%2 == 1?'È¦':'Â¦';
		System.out.println(num + "Àº " + result + "¼öÀÔ´Ï´Ù.");
		
		System.out.println(num + "Àº " + (num%2 == 1?'È¦':'Â¦') + "¼öÀÔ´Ï´Ù.");
	}
}
