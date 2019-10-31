package day5;

public class MethodLab5 {
	public static void main(String[] args) {
		int r1[] = powerArray(2);
		int r2[] = powerArray(3);
		int r3[] = powerArray(4);
		
		arrayPrint(r1);
		arrayPrint(r2);
		arrayPrint(r3);
		
		/*
		for(int i=0; i<r1.length; i++) {
			if(i == r1.length-1) {
				System.out.println(r1[i]);
			} else {
				System.out.print(r1[i] + ", ");
			}
		}
		for(int i=0; i<r2.length; i++) {
			if(i == r2.length-1) {
				System.out.println(r2[i]);
			} else {
				System.out.print(r2[i] + ", ");
			}
		}
		for(int i=0; i<r3.length; i++) {
			if(i == r3.length-1) {
				System.out.println(r3[i]);
			} else {
				System.out.print(r3[i] + ", ");
			}
		}*/
	}
	static int[] powerArray(int num) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for(int i=0; i<arr.length; i++) {
			arr[i] *= num;
		}
		return arr;
	}
	static void arrayPrint(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i == arr.length-1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
}
