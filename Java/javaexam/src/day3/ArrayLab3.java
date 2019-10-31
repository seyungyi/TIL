package day3;

public class ArrayLab3 {
	public static void main(String[] args) {
		int[] num = new int[10];
		char[] arr = new char[10];
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 26) + 1;
			arr[i] = (char)(num[i] + 64);
			if(i == num.length-1) {
				System.out.println(num[i]);
			} else {
				System.out.print(num[i] + ", ");
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(i == arr.length-1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
}
